package algcode.zuo.sort.merge;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {34, 32, 64, 12, 22, 43, 13, 24, 78, 56, 41, 6, 10, 20, 89, 67, 56, 45, 34, 12, 10, 3, 59, 33};
        System.out.println("排序前：" + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 归并排序
     *     时间复杂度：O(N*logN)	额外空间复杂度：O(N)
     *     可以实现稳定性
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 将数组分为左右两部分进行
     */
    private static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * while (p1 <= mid && p2 <= r)
     *     左边部分跟右边部分第一个元素开始比较，谁小就将谁加到辅助数组中，当其中一边的所有数都加至辅助数组中时结束此循环
     * while (p1 <= mid)    while (p2 <= r)
     *     将剩余部分的所有数依次添加至辅助数组中
     * for (int j = 0; j < help.length; j++)
     *     将辅助数组拷贝回原数组
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }
}
