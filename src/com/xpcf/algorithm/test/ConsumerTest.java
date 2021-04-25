package com.xpcf.algorithm.test;

import java.util.concurrent.TimeUnit;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/25/2021 5:37 PM
 */
public class ConsumerTest {


    public static void main(String[] args) {
        Product product = new Product();

        for (int i = 0; i < 3; i++) {
            new Producer(product, "Producer" + (i + 1)).start();
        }

        for (int i = 0; i < 3; i++) {
            new Consumer(product, "Consumer" + (i + 1)).start();
        }

    }

    static class Product {
        volatile int goods = 0;
    }

    static class Producer extends Thread {
        Product product;

        Producer(Product product, String name) {
            super(name);
            this.product = product;
        }

        @Override
        public void run() {

            try {

                while (true) {
                    synchronized (product) {
                        while (product.goods == 5) {
                            product.wait();
                        }
                        TimeUnit.MICROSECONDS.sleep(2000);

                        ++product.goods;
                        System.out.println(Thread.currentThread().getName() + "     produce" + "    current goods: " + product.goods);
                        product.notifyAll();
                    }
                    TimeUnit.MICROSECONDS.sleep(2000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class Consumer extends Thread {
        Product product;

        Consumer(Product product, String name) {
            super(name);
            this.product = product;
        }

        @Override
        public void run() {

            try {
                while (true) {
                    synchronized (product) {
                        while (product.goods == 0) {
                            product.wait();
                        }
                        TimeUnit.MICROSECONDS.sleep(2000);

                        --product.goods;
                        System.out.println(Thread.currentThread().getName() + "     consume" + "    current goods: " + product.goods);
                        product.notifyAll();
                    }
                    TimeUnit.MICROSECONDS.sleep(2000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
