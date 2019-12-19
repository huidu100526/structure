package juc.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther huidu
 * @create 2019/11/20 19:27
 * @Description: 生产者消费者模式传统版
 * 生产者：
 *     先判断是否有资源（多个线程时只能使用while，不能使用if判断），有资源就等待，没资源就生产，生产完通知消费者
 * 消费者：
 *     先判断是否有资源，没资源就等待，有资源就消费，消费完通知生产者
 *
 * 1、传统第一版
 *     使用synchronized加锁，wait()方法等待，notify()方法唤醒
 * 2、传统第二版
 *     使用lock加锁，await()方法等待，signal()方法唤醒
 */
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ProdConsumerTraditionDemo traditionDemo = new ProdConsumerTraditionDemo();

        // 5个线程生产
        new Thread(() -> {
            for (int i = 1; i <=5 ; i++) {
                traditionDemo.increment();
            }
        }, "AAA").start();

        // 5个线程消费
        new Thread(() -> {
            for (int i = 1; i <=5 ; i++) {
                traditionDemo.decrement();
            }
        }, "BBB").start();
    }

    // 资源，默认没有
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 生产者
    public void increment() {
        lock.lock();
        try {
            // 1、判断是否有资源
            while (number != 0) {
                condition.await(); // 有资源就等待
            }
            // 2、没资源就生产
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3、生产完之后通知消费者，即唤醒
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 消费者
    public void decrement() {
        lock.lock();
        try {
            // 1、判断是否有资源
            while (number == 0) {
                condition.await(); // 没资源就等待
            }
            // 2、有资源就消费
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3、消费完之后通知生产者，即唤醒
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}