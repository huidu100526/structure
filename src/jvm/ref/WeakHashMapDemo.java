package jvm.ref;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @auther huidu
 * @create 2019/12/4 20:12
 * @Description: WeakHashMap案例
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();
        myWeakHashMap();
    }

    private static void myHashMap() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        Integer key = new Integer(1); // 这里保存一个对象
        String value = "HashMap";

        System.out.println("========GC前========");
        hashMap.put(key, value);
        System.out.println(hashMap);

        key = null;
        System.out.println(hashMap);

        System.gc();

        System.out.println();
        System.out.println("========GC后========");
        System.out.println(hashMap + "\t" + hashMap.size());
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(2); // 这里保存一个对象
        String value = "WeakHashMap";

        System.out.println("========GC前========");
        weakHashMap.put(key, value);
        System.out.println(weakHashMap);

        key = null;
        System.out.println(weakHashMap);

        System.gc(); // 垃圾回收的时候，会将WeakHashMap中保存的对象给清理掉

        System.out.println();
        System.out.println("========GC后========");
        System.out.println(weakHashMap + "\t" + weakHashMap.size());
    }
}
