package collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @auther huidu
 * @create 2019/12/1 10:01
 * @Description: 集合类线程不安全demo
 * 会出现写丢失情况
 */
public class ContainNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
