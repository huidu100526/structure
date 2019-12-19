package algcode.zuo.sort.quick;

import java.util.Arrays;

public class NetherlandsFlag {
    public static void main(String[] args) {
        int[] arr = {34, 32, 64, 12, 22, 43, 13, 24, 78, 56, 41, 6, 10, 20, 89, 67, 56, 45, 34, 12, 10, 3, 59, 33};
        System.out.println("排序前：" + Arrays.toString(arr));
        partition(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 荷兰国旗
     *     按 num 数将数组分为左中右三份，小于num的在左边，等于在中间，大于的在右边
     */
    public static void partition(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        partition(arr, 0, arr.length - 1, 1);
    }

    /**
     * less 为小于 num 区域，more 为大于 num 区域，终止条件为 L 跟 more 相等时
     * 当数组中数小于num就跟 less+1 数交换，大于就跟 more-1 数交换，等于就不动
     */
    public static void partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < num) {
                swap(arr, ++less, L++);
            } else if (arr[L] > num) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
