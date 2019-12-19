package algcode.zuo.sort.basis;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {34, 32, 64, 12, 22, 43, 13, 24, 78, 56, 41, 6, 10, 20, 89, 67, 56, 45, 34, 12, 10, 3, 59, 33};
        System.out.println("排序前：" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 选择排序
     *     时间复杂度：O(N^2)
     *     不可以实现稳定性
     *     每一个元素与所有元素遍历，后边的较小就交换，一遍过后最小的元素在第一个位置
     */
    private static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = x + 1; y < arr.length; y++) {
                if (arr[y] < arr[x]) {
                    swap(arr, y, x);
                }
            }
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
