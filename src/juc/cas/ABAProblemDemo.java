package juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @auther huidu
 * @create 2019/11/01 19:26
 * @Description: ABA问题的产生
 * 一个线程从主内存获取值后将其修改，再修改回原值
 * 另一个线程获取该值，不知道中间被修改过，其对该值第三次修改操作就能成功
 */
public class ABAProblemDemo {
    // 设置初始值为100
    static AtomicReference<Integer> reference = new AtomicReference<>(100);

    public static void main(String[] args) {
        new Thread(() -> {
            reference.compareAndSet(100, 101); // 修改
            reference.compareAndSet(101, 100); // 再次修改回原值
        }, "t1").start();

        new Thread(() -> {
            // 暂停1秒钟 t2 线程，保证 t1 线程完成了一次ABA操作
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("ABA问题产生的结果：");
            System.out.println(reference.compareAndSet(100, 2019) + "\t 成功将值修改为：" + reference.get());
        }, "t2").start();
    }
}
