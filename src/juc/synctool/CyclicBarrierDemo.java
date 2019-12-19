package juc.synctool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @auther huidu
 * @create 2019/11/19 20:43
 * @Description: 同步工具类
 * 累加锁存器（用于线程排序工作）：
 *     和 CountDownLatch 相反，构造方法传入累加数和结果，只有当累加至累加数后才得到结果
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 创建累加器，参数为累加量和累加后结果
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("哈哈哈召唤神龙"));

        for (int i = 1; i <=14 ; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到第" + tempInt + "颗龙珠");
                try {
                    cyclicBarrier.await(); // 先到的先等待
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
