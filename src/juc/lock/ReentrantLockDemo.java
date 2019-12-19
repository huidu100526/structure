package juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther huidu
 * @create 2019/11/16 15:04
 * @Description: 可重入锁
 * 可重入锁（也叫递归锁）
 *     指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码
 *     同一个线程在外层函数获取锁的时候，进入内层方法会直接获得锁
 *     也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
 *
 * Demo流程：
 *     AAA线程进入sendSMS()方法后，因为是同一个对象，获得的是同一把锁，可以直接进入在sendSMS()方法里的sendEmail()方法
 *     同样BBB线程也会进入两个方法
 */
public class ReentrantLockDemo implements Runnable{
    public static void main(String[] args) {
        new Thread(() -> {
            // 执行sendSMS()方法
            try { sendSMS(); } catch (Exception e) { e.printStackTrace(); }
        }, "AAA").start();

        new Thread(() -> {
            // 执行sendSMS()方法
            try { sendSMS(); } catch (Exception e) { e.printStackTrace(); }
        }, "BBB").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("==========================");

        // 两个线程都执行get()方法
        Thread t3 = new Thread(ReentrantLockDemo::get, "AAA");
        Thread t4 = new Thread(ReentrantLockDemo::get, "BBB");
        t3.start();
        t4.start();
    }

    /**
     * synchronized可重入锁
     */
    public synchronized static void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "\tsendSMS()");
        sendEmail(); // 同一个线程会进入，并且是同一把锁
    }

    public synchronized static void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "\t进来sendEmail()");
    }

    /**
     * 下面是ReentrantLock可重入锁
     */
    public static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public static void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\tget()");
            set();
        } finally {
            lock.unlock();
        }
    }

    public static void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t进来set()");
        } finally {
            lock.unlock();
        }
    }
}
