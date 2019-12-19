package juc.synctool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @auther huidu
 * @create 2019/11/19 20:57
 * @Description: 同步工具类
 * 信号量机制：
 *     用于多个线程抢多个资源，可以代替Synchronized和ReentrantLock
 *     还用于并发线程数的控制
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // 最大抢占数，模拟3个停车位
        for (int i = 1; i <=6 ; i++) { // 模拟6辆车
            new Thread(() -> {
                try {
                    semaphore.acquire(); // 线程进来此方法抢占
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    // 抢到后停3秒离开
                    try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName() + "\t 停车3秒后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // 线程抢占后释放，立即通知其他线程可以继续使用
                }
            }, String.valueOf(i)).start();
        }
    }
}
