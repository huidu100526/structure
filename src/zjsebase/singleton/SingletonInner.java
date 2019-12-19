package zjsebase.singleton;

/**
 * @auther huidu
 * @create 2019/11/01 16:12
 * @Description: 单例内部类模式
 */
public class SingletonInner {
    private SingletonInner() {}

    private static class Inner {
        private static final SingletonInner SINGLETON = new SingletonInner();
    }

    public static SingletonInner getSingleton() {
        return Inner.SINGLETON;
    }
}
