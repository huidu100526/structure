package jvm.gc;

/**
 * @auther huidu
 * @create 2019/12/4 19:03
 * @Description: 垃圾收集器和垃圾回收算法的关系
 * 垃圾收集器就是垃圾回收算法的落地实现
 *
 * 4种垃圾回收方式：
 *     Serial：串行垃圾回收器
 *         它为单线程环境设计且只使用一个线程进行垃圾回收，会暂停所有用户线程，不适用于服务器环境
 *     Parallel：并行垃圾回收器
 *         多个垃圾收集器并行工作，此时用户线程也是暂停的，使用于科学计算/大数据处理等弱交互场景
 *     CMS（ConcMarkSweep）：并发标记清除垃圾回收器
 * 	       用户线程和垃圾收集线程同时执行，不暂停用户线程，适用对响应时间有要求的场景
 *     G1：G1垃圾回收器
 *
 * 7大垃圾收集器：
 *     串行垃圾回收器：UseSerialGC、UseSerialOldGC
 *     并行垃圾回收器：UseParallelGC、UseParallelOldGC
 *     并发标记清除垃圾回收器：UseConcMarkSweepGC、UseParNewGC
 *     G1垃圾回收器：UseG1GC
 *     UseSerialOldGC在Java8后已经被废弃
 */
public class GcDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[2 * 1024 * 1024];
        System.out.println("hahaha");
    }
}
