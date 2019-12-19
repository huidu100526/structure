package jvm.ref;

import java.lang.ref.WeakReference;

/**
 * @auther huidu
 * @create 2019/12/4 19:59
 * @Description: 弱引用
 * 需要用 WeakReference 类来实现，对于只有弱引用的对象来说，只要垃圾回收机制一运行，不管 JVM 的内存空间是否足够，总会回收该对象内存
 *
 * 软引用和弱引用的适用场景
 *     假如有一个应用需要读取大量的本地图片：
 *         如果每次读取图片都从硬盘读取则会严重影响性能
 *         如果一次性全部加载到内存中又可能造成内存溢出
 *     软引用可以解决这个问题
 *         设计思路是：用一个HashMap来保存图片的路径和相应图片对象关联的软引用直接的映射关系
 *         在内存不足时，JVM会自动回收这些缓存图片对象所占用的内存空间，从而有效避免OOM问题
 *         Map<String, SoftReference<Bitmap>> imageCache = new HashMap<>();
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println("========GC前========");
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc(); // 进行垃圾回收

        System.out.println();
        System.out.println("========GC后========");
        System.out.println(o1);
        System.out.println(weakReference.get()); // 此时没有配置内存参数内存足够，但还是被回收了
    }
}
