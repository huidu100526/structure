package zjsebase.nio;

import java.nio.ByteBuffer;

/**
 * @auther huidu
 * @create 2019/11/28 18:12
 * @Description: nio中的缓冲区
 * 负责数据的存取，缓冲区就是数组，用于存储不同数据类型的数据
 * 根据数据类型不同（boolean除外），提供了相应类型的缓冲区
 *     ByteBuffer、CharBuffer、ShoutBuffer、IntBuffer、LongBuffer、FloatBuffer、DoubleBuffer
 *     上述管理方式几乎一致，通过 allocate() 获取缓冲区
 *
 * 操作数据的两个核心方法：
 *     get()：存入数据到缓冲区中
 *     put()：获取缓冲区中的数据
 *
 * 缓冲区的四个核心属性：
 *     capacity：容量，表示缓冲区中最大存储数据的容量，一旦声明不能改变
 *     limit：界限，表示缓冲区中可以操作数据的大小
 *     position：位置，表示缓冲区中正在操作数据的位置
 *     position <= limit <= capacity
 *
 * 直接缓冲区和非直接缓冲区
 *     非直接缓冲区：通过 allocate() 方法分配缓冲区，将缓冲区建立在JVM的内存中
 *     直接缓冲区：通过 allocateDirect() 方法分配缓冲区，将缓冲区建立在物理内存中
 *     使用 isDirect() 方法判断是否是直接缓冲区
 */
public class BufferDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("当前缓冲区容量：" + byteBuffer.capacity());
        System.out.println("当前可操作上限：" + byteBuffer.limit());
        System.out.println("当前正在操作位置：" + byteBuffer.position());
        System.out.println("=================");

        byteBuffer.put("abcde".getBytes()); // 往缓冲区中添加数据
        System.out.println("当前缓冲区容量：" + byteBuffer.capacity());
        System.out.println("当前可操作上限：" + byteBuffer.limit());
        System.out.println("当前正在操作位置：" + byteBuffer.position());
        System.out.println("=================");

        byteBuffer.flip(); // 将写数据模式改为读取数据模式，相应的limit会改变
        System.out.println("当前缓冲区容量：" + byteBuffer.capacity());
        System.out.println("当前可操作上限：" + byteBuffer.limit());
        System.out.println("当前正在操作位置：" + byteBuffer.position());
        System.out.println("=================");

        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes); // 将缓冲区中的数据读取到字节数组中
        System.out.println("当前缓冲区容量：" + byteBuffer.capacity());
        System.out.println("当前可操作上限：" + byteBuffer.limit());
        System.out.println("当前正在操作位置：" + byteBuffer.position());
        System.out.println("=================");

        byteBuffer.rewind(); // 将读取数据模式恢复至写数据模式时的位置信息
        System.out.println("当前缓冲区容量：" + byteBuffer.capacity());
        System.out.println("当前可操作上限：" + byteBuffer.limit());
        System.out.println("当前正在操作位置：" + byteBuffer.position());
        System.out.println("=================");

        byteBuffer.clear(); // 清空缓冲区，但是缓冲区中的数据依然存在，还是可以读取的，只是处于“被遗忘” 状态
        System.out.println("当前缓冲区容量：" + byteBuffer.capacity());
        System.out.println("当前可操作上限：" + byteBuffer.limit());
        System.out.println("当前正在操作位置：" + byteBuffer.position());
        System.out.println("=================");
    }
}
