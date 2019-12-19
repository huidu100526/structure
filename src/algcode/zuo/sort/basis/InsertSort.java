package algcode.zuo.sort.basis;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {34, 32, 64, 12, 22, 43, 13, 24, 78, 56, 41, 6, 10, 20, 89, 67, 56, 45, 34, 12, 10, 3, 59, 33};
        System.out.println("排序前：" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 插入排序
     *     最坏时间复杂度：O(N^2)	 最好时间复杂度：O(N)
     *     可以实现稳定性
     */
    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int x = 1; x < arr.length; x++) {
            for (int y = x - 1; y >= 0 && arr[y] < arr[y + 1]; y--) {
                swap(arr, y, y + 1);
            }
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
