package juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @auther huidu
 * @create 2019/11/15 19:53
 * @Description: 自旋锁
 * 自旋锁：
 *     是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁
 *     当持有锁的线程释放锁后即可立即获取锁
 *
 * 优缺点：
 *     自旋锁尽可能的减少了线程的阻塞，好处是减少线程上下文切换的消耗
 *     因为自旋的消耗会小于线程阻塞挂起再唤醒(导致线程发生两次上下文切换)的操作的消耗
 *
 *     当锁竞争激烈，或者持有锁的线程长时间占用锁，此时自旋过程会一直占用CPU，消耗CPU，造成CPU浪费
 *     大量线程在竞争锁时，会导致获取锁的时间很长，线程自旋的消耗大于线程阻塞挂起操作的消耗
 *
 * Demo流程：
 *     AAA先进入myLock，先进行CAS判断后通过，然后将锁占有5秒
 *     此时BBB进入myLock，进行CAS时，因为AAA占有锁，所以不能通过，会一直循环判断能不能拿到锁
 *     最后5秒过后，BBB成功拿到锁
 */
public class SpinLockDemo {
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            // 此线程占有锁5秒钟
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.myUnLock();
        }, "AAA").start();

        // 睡眠1秒，保证AAA先执行
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> {
            spinLockDemo.myLock();
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLockDemo.myUnLock();
        }, "BBB").start();
    }

    // 原子引用类
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t 进来了");
        // 获得锁并进行自旋判断
        while (!atomicReference.compareAndSet(null, thread)){};
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t myUnLock");
        // 释放锁
        atomicReference.compareAndSet(thread, null);
    }
}
