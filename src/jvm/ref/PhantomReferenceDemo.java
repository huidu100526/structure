package jvm.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @auther huidu
 * @create 2019/12/5 13:26
 * @Description: 虚引用
 * 需要用 PhantomReference 类来实现，如果一个对象仅持有虚引用，就相当于没有任何引用一样
 * 它不能单独使用，必须和引用队列联合使用，当GC释放对象内存的时候，会将引用加入到引用队列
 * 如果某个程序发现某个虚引用被加入到引用队列中，那么就可以在所引用的对象的内存被回收之前采取必要的行动
 * 虚引用的主要作用是跟踪对象被垃圾回收的状态
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, referenceQueue); // 一定要包含引用队列
        System.out.println("========GC前========");
        System.out.println(o1);
        System.out.println(phantomReference.get()); // 形同虚设，每次调用都为null
        System.out.println(referenceQueue.poll()); // 队列中没值

        o1 = null;
        System.gc(); // 进行垃圾回收
        Thread.sleep(500);

        System.out.println();
        System.out.println("========GC后========");
        System.out.println(o1); // 被回收
        System.out.println(phantomReference.get()); // 形同虚设，每次调用都为null
        System.out.println(referenceQueue.poll()); // 进行回收后，将回收的引用装到引用队列中，所以回收后有值
    }
}
