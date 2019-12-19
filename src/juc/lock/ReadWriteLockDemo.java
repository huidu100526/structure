package juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther huidu
 * @create 2019/11/16 15:04
 * @Description: 读写锁演示
 * Demo流程：
 *     在没有加锁时：5个线程在写入的过程中，还没写入完成就会被其他线程抢走，导致写入时被加塞
 *     加锁后：5个线程在写入过程中，每一个线程写入完成写一个线程才能进行写入操作，而读操作不控制
 *         创建读写锁ReentrantReadWriteLock()，其读锁是共享锁，其写锁是独占锁
 *         分别使用读写锁的写锁对写操作进行加锁，读锁对读操作进行加锁
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLockDemo myCache = new ReadWriteLockDemo();

        // 5个线程进行写操作
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> myCache.put(tempInt + "", tempInt + ""), String.valueOf(i)).start();
        }

        // 5个线程进行读操作
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> myCache.get(tempInt + ""), String.valueOf(i)).start();
        }
    }

    // 创建一个容器，要保证可见性
    private volatile Map<String, Object> map = new HashMap<>();
    // 创建读写锁
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 写入操作
    public void put(String key, Object value) {
        readWriteLock.writeLock().lock(); // 使用写锁进行加锁
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            // 暂停一会线程
            try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock(); // 写锁释放锁
        }
    }

    // 读取操作
    public void get(String key) {
        readWriteLock.readLock().lock(); // 使用读锁进行加锁
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取");
            // 暂停一会线程
            try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock(); // 读锁释放锁
        }
    }
}