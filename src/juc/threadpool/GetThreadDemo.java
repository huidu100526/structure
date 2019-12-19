package juc.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther huidu
 * @create 2019/11/23 14:02
 * @Description: Callable获得线程
 */
public class GetThreadDemo implements Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new GetThreadDemo());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("返回的结果：" + futureTask.get());
    }

    @Override
    public Object call() {
        return 1024;
    }
}