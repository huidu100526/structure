package collection.map;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @auther huidu
 * @create 2019/11/21 20:43
 * @Description:
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        HashMap<String, String> map = new HashMap<>();
        System.out.println(String.valueOf(1 << 30));
    }

    final float loadFactor; // 加载因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f; // 加载因子默认值0.75
    int threshold; // 阀值
    static final int MAXIMUM_CAPACITY = 1 << 30; // 1073741824

    public HashMapDemo() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public HashMapDemo(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public HashMapDemo(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY; // 容量最大值1073741824
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
