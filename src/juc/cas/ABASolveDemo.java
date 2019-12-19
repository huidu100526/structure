package juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @auther huidu
 * @create 2019/11/01 19:35
 * @Description: ABA问题的解决
 * 使用AtomicStampedReference<Integer>，添加版本号，每次修改都要修改版本号
 * 只有值跟版本号一样才能继续修改
 */
public class ABASolveDemo {
    // 设置初始值为100，初始版本号为1
    static AtomicStampedReference<Integer> reference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            int stamp = reference.getStamp(); // 得到初始版本号
            System.out.println(Thread.currentThread().getName() + "\t 第1次版本号："+stamp);
            // 暂停1秒钟 t1 线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

            reference.compareAndSet(100, 101, reference.getStamp(), reference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第2次版本号：" + reference.getStamp());
            reference.compareAndSet(101, 100, reference.getStamp(), reference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第3次版本号：" + reference.getStamp());
        }, "t1").start();

        new Thread(() -> {
            int stamp = reference.getStamp(); // 得到初始版本号
            System.out.println(Thread.currentThread().getName() + "\t 第1次版本号："+stamp);
            // 暂停3秒钟 t2 线程，保证 t1 线程完成一次ABA操作
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }

            boolean result = reference.compareAndSet(100, 2019, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t 修改成功与否：" + result +
                    "\t 当前最新实际版本号：" + reference.getStamp());
            System.out.println(Thread.currentThread().getName() + "\t 当前实际最新值：" + reference.getReference());
        }, "t2").start();
    }
}
