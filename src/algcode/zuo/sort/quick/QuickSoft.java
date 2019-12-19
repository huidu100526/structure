package algcode.zuo.sort.quick;

import java.util.Arrays;

public class QuickSoft {
    public static void main(String[] args) {
        int[] arr = {34, 32, 64, 12, 22, 43, 13, 24, 78, 56, 41, 6, 10, 20, 89, 67, 56, 45, 34, 12, 10, 3, 59, 33};
        System.out.println("排序前：" + Arrays.toString(arr));
        quickSoft(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 随机快速排序
     *     时间复杂度O(N*logN)	额外空间复杂度O(logN)
     *     不可以实现稳定性
     */
    private static void quickSoft(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R); // 随机取数组中的一个数作为比较点
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    /**
     * 参考荷兰国旗
     * 返回的是相等区域中的第一个和最后一个
     * less 为小于 num 区域，more 为大于 num 区域，终止条件为 L 跟 more 相等时
     * 当数组中数小于num就跟 less+1 数交换，大于就跟 more-1 数交换，等于就不动
     */
    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
