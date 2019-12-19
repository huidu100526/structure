package jvm.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @auther huidu
 * @create 2019/12/5 13:15
 * @Description: 引用队列
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);

        System.out.println("========GC前========");
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll()); // 队列中没值

        o1 = null;
        System.gc(); // 进行垃圾回收
        Thread.sleep(500);

        System.out.println();
        System.out.println("========GC后========");
        System.out.println(o1); // 被回收
        System.out.println(weakReference.get()); // 被回收
        System.out.println(referenceQueue.poll()); // 进行回收后，将回收的引用装到引用队列中，所以回收后有值
    }
}
