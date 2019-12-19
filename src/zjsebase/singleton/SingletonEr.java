package zjsebase.singleton;

/**
 * @auther huidu
 * @create 2019/11/01 16:09
 * @Description: 单例饿汉式
 */
public class SingletonEr {
    private static SingletonEr singletonEr = new SingletonEr();

    private SingletonEr() {}

    public static SingletonEr getSingletonEr() {
        return singletonEr;
    }
}
