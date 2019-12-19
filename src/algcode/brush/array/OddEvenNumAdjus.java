package algcode.brush.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @auther huidu
 * @create 2019/12/2 10:04
 * @Description: 调整数组顺序
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class OddEvenNumAdjus {
    public static void main(String[] args) {
        int[] arr = {34, 32, 64, 12, 22, 43, 13, 24, 78, 56, 41, 6, 10, 20, 89, 67, 56, 45, 34, 12, 10, 3, 59, 33};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reOrderArray(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>(); // 装奇数
        ArrayList<Integer> even = new ArrayList<>(); // 装偶数
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                odd.add(array[i]);
            } else {
                even.add(array[i]);
            }
        }
        int m = 0;
        for (int i = 0; i < odd.size(); i++) {
            array[m] = odd.get(i); // 将奇数装入前半段
            m++;
        }
        for (int i = 0; i < even.size(); i++) {
            array[m] = even.get(i); // 将偶数装入后半段
            m++;
        }
    }
}
