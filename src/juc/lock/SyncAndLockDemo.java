package juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther huidu
 * @create 2019/11/21 10:14
 * @Description: Synchronized和Lock的区别，使用lock有什么好处
 * 两者默认都是非公平锁、可重入锁、独占锁
 * 公平锁：是指多个线程按照申请锁的顺序来获取锁，先到先得
 * 非公平锁：是指多个线程获取锁的顺序有可能后申请的线程比先申请的线程先获取锁
 *           在高并发情况下，有可能会造成优先级反转或饥饿现象
 *
 * 两者区别：
 *     公平锁，就是很公平，在并发情况下，每个线程在获取锁时会先查看此锁维护的等待队列，
 *     如果为空，或者当前线程是等待队列的第一个，就占有锁，否则就加入等待队列中等待。
 *
 *     非公平锁，比较粗鲁，一来就直接尝试获得锁，如果尝试失败，再采用公平锁的方式
 *
 * 题目：多线程之间按顺序调用，实现A -> B -> C三个线程启动
 * 	   A打印5次，B打印10次，C打印15次
 * 	   紧接着
 * 	   A打印5次，B打印10次，C打印15次 。。。 来10轮
 *
 * lock最大的好处是：可以精确唤醒线程，不像Synchronized要么随机唤醒一个线程要么唤醒全部线程
 */
public class SyncAndLockDemo {
    public static void main(String[] args) {
        SyncAndLockDemo syncAndLockDemo = new SyncAndLockDemo();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) { // 来10轮
                syncAndLockDemo.print5();
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) { // 来10轮
                syncAndLockDemo.print10();
            }
        }, "BBB").start();

        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) { // 来10轮
                syncAndLockDemo.print15();
            }
        }, "CCC").start();
    }

    private int number = 1;
    private Lock lock = new ReentrantLock();
    // 使用lock创建3个线程，下面就可以精确控制某个线程的唤醒
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            // 判断
            while (number != 1) {
                c1.await(); // 1线程等待
            }
            // 干活
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知
            number = 2;
            c2.signal(); // 接着通知2线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            // 判断
            while (number != 2) {
                c2.await(); // 2线程等待
            }
            // 干活
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知
            number = 3;
            c3.signal(); // 接着通知3线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            // 判断
            while (number != 3) {
                c3.await(); // 3线程等待
            }
            // 干活
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知
            number = 1;
            c1.signal(); // 接着通知1线程
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
