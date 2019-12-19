package juc.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther huidu
 * @create 2019/11/20 21:09
 * @Description: 生产者消费者模式
 * 阻塞队列版：
 *     通过使用判断标识来决定是否生产和消费，此标识加上volatile保证修改标识后其他线程立刻可知
 *     使用AtomicInteger来生产数据，保证原子性，即生产数据的过程不被加塞，并使用BlockingQueue来装载数据
 *     生产者将生产的数据装入阻塞队列，消费者从阻塞队列中取数据来消费，从而保证生产一个消费一个
 */
public class ProdConsumerBlockQueueDemo {
    public static void main(String[] args) {
        ProdConsumerBlockQueueDemo blockQueue = new ProdConsumerBlockQueueDemo(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                blockQueue.myProd(); // 生产
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            System.out.println();
            try {
                blockQueue.myConsumer(); // 消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者").start();

        // 暂停5秒钟
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println();
        System.out.println("5秒时间到，main线程叫停，结束生产消费");
        System.out.println();
        blockQueue.stop(); // 修改标识
    }

    private volatile boolean flag = true; // 判断标识，默认开启，表示要生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue;

    public ProdConsumerBlockQueueDemo(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println("使用的阻塞队列是：" + blockingQueue.getClass().getName()); // 输出传入的是哪种类型
    }

    // 生产
    public void myProd() throws InterruptedException {
        String data;
        boolean value;
        // 判断标识
        while (flag) {
            // 生产数据
            data = atomicInteger.incrementAndGet() + "";
            // 将数据装入阻塞队列
            value = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (value) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            // 一秒生产一个
            TimeUnit.SECONDS.sleep(1);
        }
        // 一旦flag变为false，此线程马上可知，因为volatile保证可见性，就会输出下面的话
        System.out.println(Thread.currentThread().getName() + "\t main线程叫停，表示flag = false，停止生产");
    }

    // 消费
    public void myConsumer() throws InterruptedException {
        String result;
        // 判断标识
        while (flag) {
            // 消费数据，即从阻塞队列中取出数据
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过2秒没有取到蛋糕，停止消费");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "蛋糕成功");
        }
    }

    // 叫停
    public void stop() {
        this.flag = false;
    }
}