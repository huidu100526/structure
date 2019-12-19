package jvm.ref;

import java.lang.ref.SoftReference;

/**
 * @auther huidu
 * @create 2019/12/4 19:43
 * @Description: 软引用
 * 需要用 SoftReference 类来实现，当系统内存足够时它不会被回收，当系统内存不足时它会被回收
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {
//        softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }

    // 内存够用时
    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println("========GC前========");
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc(); // 开启回收

        System.out.println();
        System.out.println("========GC后========");
        System.out.println(o1); // 变为null
        System.out.println(softReference.get()); // 还存在，内存够用就没有被回收
    }

    /**
     * 内存不够用时
     * 需要配置jvm参数，配置小内存，使之导致OOM，看软引用回收情况
     * -Xms2m -Xmx2m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println("========GC前========");
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try {
            byte[] bytes = new byte[2 * 1024 * 1024]; // new一个内存大于所配置的2m的对象
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println();
            System.out.println("========内存不够时========");
            System.out.println(o1);
            System.out.println(softReference.get()); // 这时内存不够，就可以看到软引用对象被回收
        }
    }
}
