package algcode.brush.array;

import java.util.Arrays;

/**
 * @auther huidu
 * @create 2019/11/21 15:00
 * @Description: 数组中出现超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNumSolution(ints));
    }

    public static int moreThanHalfNumSolution(int[] array) {
        int len = array.length;
        if (len < 1) {
            return 0;
        }
        int mid = len / 2;
        int count = 0; // 记录出现的次数
        Arrays.sort(array); // 将数组排序，如果有那个数字，则数组中间的数必定是那个数
        for (int i = 0; i < len; i++) {
            if (array[i] == array[mid]) { // 等于中间那个数的话统计出现次数
                count++;
            }
        }
        if (count <= mid) { // 出现的次数小于数组长度一半则不存在返回0
            return 0;
        }
        return array[mid];
    }
}
