package algcode.brush.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @auther huidu
 * @create 2019/11/30 16:55
 * @Description: 最小的k个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class MinKNum {
    public static void main(String[] args) {
        int[] arr = {34, 32, 64, 12, 22, 43, 13, 24, 78, 56, 41, 6, 10, 20, 89, 67, 56, 45, 34, 12, 10, 3, 59, 33};
        System.out.println(getLeastNumbers(arr, 5));
    }

    public static ArrayList<Integer> getLeastNumbers(int[] array, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = array.length;
        if (array == null || len <= 0 || k <= 0 || k > len) {
            return list;
        }
        Arrays.sort(array); // 先进行排序
        for (int i = 0; i < k; i++) { // 只需遍历前k个数
            list.add(array[i]);
        }
        return list;
    }
}
