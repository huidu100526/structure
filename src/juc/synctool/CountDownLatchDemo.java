package juc.synctool;

import java.util.concurrent.CountDownLatch;

/**
 * @auther huidu
 * @create 2019/11/19 20:21
 * @Description: 同步工具类（闭锁）
 * 倒计时锁存器（用于线程排序工作）：
 *     构造方法传入一个数作为倒计时数，只有当倒计时结束后才能通过 await() 方法
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        // 创建倒计时器，参数为倒计时数
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国，被灭");
                countDownLatch.countDown(); // 倒计时
            }, CountryEnum.forEach_CountryEnum(i).getMessage()).start();
        }
        try {
            countDownLatch.await(); // 倒计时结束前都等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t 秦国一统华夏");
    }

    /**
     * 国家枚举
     */
    enum CountryEnum {
        ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");

        private Integer code;
        private String message;

        CountryEnum(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public static CountryEnum forEach_CountryEnum(int index) {
            CountryEnum[] countryEnums = CountryEnum.values();
            for (CountryEnum countryEnum : countryEnums) {
                if (index == countryEnum.getCode()) {
                    return countryEnum;
                }
            }
            return null;
        }
    }
}

