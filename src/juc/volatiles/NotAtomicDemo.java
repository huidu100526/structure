package juc.volatiles;

/**
 * @auther huidu
 * @create 2019/11/20 16:48
 * @Description: 验证volatile不保证原子性
 * 原子性：
 *     原子性是指操作的数据不可分割，正在操作时不可被其他线程加塞
 * 最后结果不足20000，因为不保证原子性，加加操作分为3步，先赋值，在加一，最后写回主内存，这已经不是原子操作
 * 这样就可以有多个线程在第一步时先获取值，然后加一操作最后写回的时候
 * 因为先获取了值，其他线程对变量修改的通知已经不是第一步了，再次写回造成写丢失
 */
public class NotAtomicDemo {
    public static void main(String[] args) {
        NotAtomicDemo notAtomicDemo = new NotAtomicDemo();

        // 创建20个线程
        for (int i = 1; i <=20 ; i++) {
            new Thread(() -> {
                // 每个线程进行加加操作1000次
                for (int j = 1; j <=1000 ; j++) {
                    notAtomicDemo.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        // 只要活动线程数大于2，就让main线程等待
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        // 最后main线程计算最后结果
        System.out.println(Thread.currentThread().getName() + "\t 最后结果是：" + notAtomicDemo.number);
    }

    // 数据值变量
    volatile int number = 0;
    // 变量加加操作，可以通过加synchronized保证原子性
    public synchronized void addPlusPlus() {
        number++;
    }
}
