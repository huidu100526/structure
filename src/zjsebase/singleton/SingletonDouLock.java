package zjsebase.singleton;

/**
 * @auther huidu
 * @create 2019/11/01 16:06
 * @Description: 单例双重检验锁模式
 */
public class SingletonDouLock {
    private static volatile SingletonDouLock singletonDouLock;

    private SingletonDouLock() {}

    public static SingletonDouLock getSingletonDouLock() {
        if (singletonDouLock == null) {
            synchronized (SingletonDouLock.class) {
                if (singletonDouLock == null) {
                    singletonDouLock = new SingletonDouLock();
                }
            }
        }
        return singletonDouLock;
    }
}
