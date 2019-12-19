package jvm.ref;

/**
 * @auther huidu
 * @create 2019/11/30 19:43
 * @Description: 强引用
 * 把一个对象赋给一个引用变量，这个引用变量就是一个强引用
 * 这时这个对象是不可能被垃圾回收机制回收的，即使没有被用到也不会回收
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object(); // 这样定义的默认就是强引用
        Object obj2 = obj1; // 强引用，把一个对象赋给一个引用变量
        obj1 = null;
        System.gc();
        System.out.println("========GC后========");
        System.out.println(obj1); // obj1被回收
        System.out.println(obj2); // obj2不会被回收
    }
}
