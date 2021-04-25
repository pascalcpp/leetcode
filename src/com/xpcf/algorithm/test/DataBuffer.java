package com.xpcf.algorithm.test;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/25/2021 9:08 PM
 */
public class DataBuffer {
    private int maxSize;
    private LinkedList<Date> buffer;

    private Lock lock;
    private Condition producer;
    private Condition consumer;

    public DataBuffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<Date>();

        lock = new ReentrantLock();

        producer = lock.newCondition();
        consumer = lock.newCondition();
    }

    public void put() {
        lock.lock();
        try {

            while (buffer.size() == this.maxSize) {
                producer.await();
            }

            buffer.add(new Date());

            System.out.printf("%s: Add one %s. Buffer size is %d.\n",
                    Thread.currentThread().getName(),
                    buffer.peekLast(),
                    buffer.size());

            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();
        try {

            while (buffer.size() == 0) {
                consumer.await();
            }

            System.out.printf("%s: Get one %s. Buffer size is %d.\n",
                    Thread.currentThread().getName(),
                    buffer.pollFirst(),
                    buffer.size());

            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    static class Producer implements Runnable {
        private DataBuffer buffer;

        public Producer(DataBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            while (true) {
                buffer.put();
            }
        }
    }

    static class Consumer implements Runnable {
        private DataBuffer buffer;

        public Consumer(DataBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            while (true) {
                buffer.get();
            }

        }
    }

    static class ProducerTask implements Runnable {
        private DataBuffer buffer;

        public ProducerTask(DataBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                new Thread(new Producer(buffer), "Producer-" + i).start();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }


    static class ConsumerTask implements Runnable {
        private DataBuffer buffer;

        public ConsumerTask(DataBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                new Thread(new Consumer(buffer), "Consumer-" + i).start();
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    public static void main(String[] args) {
        DataBuffer buffer = new DataBuffer(5);

        new Thread(new ProducerTask(buffer), "ProducerTask").start();
        new Thread(new ConsumerTask(buffer), "ConsumerTask").start();
    }


}




