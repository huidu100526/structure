package collection.list;

import java.util.Arrays;

/**
 * @auther huidu
 * @create 2019/11/20 9:54
 * @Description: 源码分析
 */
public class ArrayListDemo<E> {
    // 初始容量
    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    // 空数组
    transient Object[] elementData;

    private int size;

    // 空参构造方法，定义一个空数组
    public ArrayListDemo() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    // 单参数构造方法
    public ArrayListDemo(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    // 此方法是供使用者调用，当需要add大量元素时前调用，以减少增量重新分配的次数
    public void ensureCapacity(int minCapacity) {
        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) ? 0 : DEFAULT_CAPACITY;
        if (minCapacity > minExpand) { // 如果容量大于数组容量
            ensureExplicitCapacity(minCapacity);
        }
    }

    // 判断容量是否进行扩容
    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0)
            grow(minCapacity); // 当 minCapacity 添加的容量大于数组容量时
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    // 扩容方法
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length; // 原数组长度10
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 10 + （10 / 2）= 15 扩容原来容量的1.5倍
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0) // 最大容量为 Integer.MAX_VALUE
            newCapacity = hugeCapacity(minCapacity);
        elementData = Arrays.copyOf(elementData, newCapacity); // 用新容量健一个拷贝数组，原数组被废弃
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    // add()方法，当添加第一个元素的时候才进行扩容
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    // 指定位置添加元素
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    // 确定容量大小
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            // 第一次添加元素自动扩容容量到10
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
}
