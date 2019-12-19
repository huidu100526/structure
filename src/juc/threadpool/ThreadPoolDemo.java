package juc.threadpool;

import java.util.concurrent.*;

/**
 * @auther huidu
 * @create 2019/11/23 10:47
 * @Description: 线程池测试
 * ExecutorService threadPool = Executors.newFixedThreadPool(5);
 *     固定线程数的线程池，参数为线程数，任务再多也就5个线程来执行
 * ExecutorService threadPool = Executors.newCachedThreadPool();
 *     一池多线程，有任务就创建线程来执行，没有上限，没有任务就回收线程
 *     如果中间暂停一会，那么一个线程能执行就全部一个线程来执行
 * ExecutorService threadPool = Executors.newSingleThreadExecutor();
 *     一池一线程，只有一个线程来执行任务
 * ExecutorService threadPool = Executors.newScheduledThreadPool(3);
 *     周期性执行任务线程池，参数为初始核心线程数，参数多少就使用多少线程来执行任务，内部使用优先级队列
 *     优先级队列，它会对插入的数据进行优先级排序，保证优先级越高的数据首先被获取，与数据的插入顺序无关
 * ExecutorService threadPool = Executors.newWorkStealingPool();
 *     Java8新增，使用目前机器上可用的处理器作为它的并行级别
 *
 * 该使用哪一个线程池：
 *     不使用JDK自带的4种线程池，应该自定义线程池，合理的根据实际情况配置参数
 *
 * 线程池7大参数：
 *     corePoolSize：线程池中的常驻核心线程数
 *     maximumPoolSize：线程池能够容纳同时执行的最大线程数，此值必须大于等于1
 *     keepAliveTime：多余的空闲线程的存活时间
 *     unit：keepAliveTime的时间单位
 *     workQueue：任务队列，被提交但尚未被执行的任务将在队列中等待
 *     threadFactory：生成线程池中工作线程的线程工厂，用于创建线程，一般用默认的即可
 *     handler：拒绝策略，当队列满了并且工作线程大于等于线程池的最大线程数时开启
 *
 * 拒绝策略：
 *     AbortPolicy()：直接抛出 java.util.concurrent.RejectedExecutionException 异常
 *     CallerRunsPolicy()：将执行不了的任务回退给调用者去执行，下面是回退给main线程执行
 *     DiscardOldestPolicy()：抛弃队列中等待最久的任务
 *     DiscardPolicy()：直接抛弃不能处理的任务
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 获得CPU核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 固定线程数线程池：工作线程数5，最大工作线程数5，阻塞队列 LinkedBlockingQueue 的最大可等待长度 Integer.MAX_VALUE
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        // 一池多线程：工作线程数0，最大工作线程数 Integer.MAX_VALUE，阻塞队列 SynchronousQueue，空闲线程等待超过60秒就销毁线程
        ExecutorService threadPool2 = Executors.newCachedThreadPool();
        // 一池一线程：工作线程数1，最大工作线程数1，阻塞队列 LinkedBlockingQueue 的最大可等待长度 Integer.MAX_VALUE
        ExecutorService threadPool3 = Executors.newSingleThreadExecutor();
        // 工作线程数3，最大工作线程数 Integer.MAX_VALUE，优先级队列 DelayedWorkQueue
        ExecutorService threadPool4 = Executors.newScheduledThreadPool(3);
        // Java8新增，使用目前机器上可用的处理器作为它的并行级别
        ExecutorService threadPool5 = Executors.newWorkStealingPool();

        // 自定义线程池：工作线程数2，最大工作线程数5，阻塞队列容量3，最大可接受线程数为8，任务数超过8将启动拒绝策略
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 1L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            // 模拟10个用户来办理业务，每一个用户就是一个来自外部的请求线程
            for (int i = 1; i <=40 ; i++) {
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "\t 办理业务"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown(); // 关闭线程池
        }
    }
}
