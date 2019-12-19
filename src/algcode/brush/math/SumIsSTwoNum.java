package algcode.brush.math;

import java.util.ArrayList;

/**
 * @auther huidu
 * @create 2019/12/9 10:35
 * @Description: 和为S的两个数
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class SumIsSTwoNum {
    public static void main(String[] args) {
    }

    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0; // 左指针
        int r = array.length - 1; // 右指针
        while (l < r) {
            if (array[l] + array[r] == sum) { // 遇到和相等了将两个数添加到列表，因为数组递增，所以返回的是乘积最小的
                list.add(array[l]);
                list.add(array[r]);
                break;
            } else if (array[l] + array[r] > sum) {
                r--;
            } else {
                l++;
            }
        }
        return list;
    }
}
