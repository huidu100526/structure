package juc.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * @auther huidu
 * @create 2019/11/20 16:34
 * @Description: 验证volatile保证可见性
 * 可见性：
 *     多个线程同时操作主内存中的变量时，当一个线程修改了变量的值再次写回至主内存中
 *     其他线程不能在第一时间知道变量已经被修改，而给这个变量添加volatile关键字就能保证其他线程可知，这就是可见性
 */
public class VisibilityDemo {
    public static void main(String[] args) {
        VisibilityDemo visibilityDemo = new VisibilityDemo();

        // 创建一个线程对数据进行修改
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 进来了");
            // 暂停一会线程
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            visibilityDemo.addTo60(); // 3秒后将值改为60
            System.out.println(Thread.currentThread().getName() + "\t 修改后的值为：" + visibilityDemo.number);
        }, "AAA").start();

        // 只要main线程知道值不等于0了，才跳出
        while (visibilityDemo.number == 0) { }
        // 在数据值变量没有被volatile修饰时，其他线程对值的修改main线程是不知道的，即会在whlie中一直循环
        System.out.println(Thread.currentThread().getName() + "\t 知道值被修改了");
    }

    // 数据值变量
    volatile int number = 0;
    // 修改变量值操作
    public void addTo60() {
        this.number = 60;
    }
}
