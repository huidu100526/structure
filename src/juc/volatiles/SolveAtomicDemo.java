package juc.volatiles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther huidu
 * @create 2019/11/20 17:06
 * @Description: 解决volatile不保证原子性的问题
 * 如何解决：
 *     1、加synchronized
 *     2、使用juc包下的AtomicInteger
 */
public class SolveAtomicDemo {
    public static void main(String[] args) {
        SolveAtomicDemo solveAtomicDemo = new SolveAtomicDemo();

        // 创建20个线程
        for (int i = 1; i <=20 ; i++) {
            new Thread(() -> {
                // 每个线程进行加加操作1000次
                for (int j = 1; j <=1000 ; j++) {
                    solveAtomicDemo.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }

        // 只要活动线程数大于2，就让main线程等待
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        // 最后main线程计算最后结果
        System.out.println(Thread.currentThread().getName() + "\t 最后结果是：" + solveAtomicDemo.atomicInteger);
    }

    // 数据值变量
    AtomicInteger atomicInteger = new AtomicInteger();
    // 变量加加操作
    public void addMyAtomic() {
        atomicInteger.getAndIncrement();
    }
}
