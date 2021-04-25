package com.xpcf.algorithm.test;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/25/2021 6:04 PM
 */
public class ConsumerTestLock {

    public static void main(String[] args) {
        Data data = new Data(0, 5);


        new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                new Consumer("Consumer" + (i + 1), data).start();
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                new Producer("Producer" + (i + 1), data).start();
            }
        }).start();

//        for (int i = 0; i < 9; i++) {
//            new Producer("Producer" + (i + 1), data).start();
//        }
//        for (int i = 0; i < 9; i++) {
//            new Consumer("Consumer" + (i + 1), data).start();
//        }

    }
}

class Data {

    volatile int count = 0;
    int capacity;
    Lock lock;
    Condition empty;
    Condition full;

    public Data(int count, int capacity) {
        this.count = count;
        this.capacity = capacity;
        lock = new ReentrantLock(false);
        empty = lock.newCondition();
        full = lock.newCondition();
    }

    public void put1() throws InterruptedException {

        synchronized (this) {
            while (count == capacity) {
                this.wait();
            }
            TimeUnit.MICROSECONDS.sleep(100);
            ++count;
            System.out.println(Thread.currentThread().getName() + "     produce" + "    current goods: " + count);
            this.notifyAll();
        }

    }

    public void put2() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "  produce get lock");

            while (count == capacity) {
                System.out.println(Thread.currentThread().getName() + "  produce block");
                full.await();
            }
            TimeUnit.MILLISECONDS.sleep(5000);
            ++count;
            System.out.println(Thread.currentThread().getName() + "     produce" + "    current goods: " + count);
            empty.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take1() throws InterruptedException {

        synchronized (this) {
            while (count == 0) {
                this.wait();
            }
            TimeUnit.MICROSECONDS.sleep(100);
            --count;
            System.out.println(Thread.currentThread().getName() + "     consume" + "    current goods: " + count);
            this.notifyAll();

        }
    }

    public void take2 () {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "  consumer get lock");

            while (count == 0) {
                System.out.println(Thread.currentThread().getName() + "  consumer block");
                empty.await();
            }
            TimeUnit.MICROSECONDS.sleep(20);
            --count;
            System.out.println(Thread.currentThread().getName() + "     consume" + "    current goods: " + count);
            full.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Producer extends Thread {

    Data data;

    public Producer(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {

        while (true) {
            try {
                data.put2();
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer extends Thread {

    Data data;

    public Consumer(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {

        while (true) {
            try {
                data.take2();
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




