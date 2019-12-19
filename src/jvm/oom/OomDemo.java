package jvm.oom;

/**
 * @auther huidu
 * @create 2019/12/5 14:49
 * @Description: OOM
 * java.lang.StackOverflowError
 *     栈内存溢出，属于Error级别，深度的方法调用，即太多方法重复调用会导致栈满
 *
 * java.lang.OutOfMemoryError: java heap space
 * 	   堆内存溢出，属于Error级别，创建的对象太多会导致堆满
 *
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 * 	   GC回收时间过长，即超过98%的时间来做GC并且只回收了一点点内存
 * 	   就是回收完这一点店内存后又马上被填满，又不得不继续GC，如此循环导致报错
 *
 * java.lang.OutOfMemoryError: Direct buffer memory
 *     写NIO程序经常适用ByteBuffer来读取或者写入数据，它可以直接使用Native函数库直接分配堆外内存
 *     然后通过一个存储在Java堆里面的DirectByteBuffer对象作为这块内存的引用进行操作
 *     ByteBuffer.allocteDirect(capability)  这种方式是分配操作系统本地内存，不属于GC管理范围
 *     但如果不断分配本地内存，堆内存很少用，那么JVM久不需要执行GC，DirectByteBuffer对象久不会被回收
 *     这时堆内存充足，但本地内存可能满了，再次尝试分配本地内存就会报错
 *
 * java.lang.OutOfMemoryError: unable to create new native thread
 *     1、当应用创建太多线程了，超过系统承载极限会报错
 *     2、linux系统默认允许单个进程可以创建的线程数是1024个，超过这个数就会报错
 *
 *     解决：
 *         1、想办法降低应用创建线程的数量
 *         2、确实有需要创建那么多线程的时候，可以修改linux服务器配置，扩大线程数创建限制
 *
 * java.lang.OutOfMemoryError: Metaspace
 *     元空间内存溢出
 */
public class OomDemo {
}
