package jvm.gcroots;

/**
 * @auther huidu
 * @create 2019/11/30 19:30
 * @Description:
 */
public class HelloGC {
    public static void main(String[] args) {
        // 返回Java虚拟机中初始内存大小，默认是电脑内存的 1/64
        long totalMemory = Runtime.getRuntime().totalMemory();
        // 返回Java虚拟机视图使用的最大堆内存大小，默认是电脑内存的 1/4
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("(-Xms) = " + totalMemory + "(字节)、" + (totalMemory / (double)1024 / 1024) + "MB");
        System.out.println("(-Xmx) = " + maxMemory + "(字节)、" + (maxMemory / (double)1024 / 1024) + "MB");
    }
}
