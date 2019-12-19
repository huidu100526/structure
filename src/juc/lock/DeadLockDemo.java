package juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * @auther huidu
 * @create 2019/11/23 12:52
 * @Description: 死锁
 * 死锁：
 *     是指两个或两个以上的进程在执行过程中，因相互竞争资源而造成的一种相互等待现象，若无外力干涉，它们都将无法推进下去
 *     如果系统资源充足，进程的资源请求都能得到满足，死锁出现的可能性就很低，否则资源有限就可能陷入死锁
 */
public class DeadLockDemo implements Runnable {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new DeadLockDemo(lockA, lockB), "AAA").start();
        new Thread(new DeadLockDemo(lockB, lockA), "BBB").start();
    }

    private final String lockA;
    private final String lockB;

    public DeadLockDemo(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获得：" + lockB);
            // 暂停一会线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获得：" + lockB);
            }
        }
    }
}
