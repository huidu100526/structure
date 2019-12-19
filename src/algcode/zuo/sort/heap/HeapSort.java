package algcode.zuo.sort.heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {34, 32, 64, 12, 22, 43, 13, 24, 78, 56, 41, 6, 10, 20, 89, 67, 56, 45, 34, 12, 10, 3, 59, 33};
        System.out.println("排序前：" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 堆排序
     *     时间复杂度：O(N*logN)  额外空间复杂度O(1)
     *     不可以实现稳定性
     */
    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i); // heapInsert()方法将数组变成大根堆，这一步时间复杂度为O(N)
        }
        int size = arr.length;
        swap(arr, 0, --size); // 堆顶元素与最后一个元素交换，并将堆的范围减一
        while (size > 0) { // 当堆的范围减为0时排序结束
            heapfiy(arr, 0, size); // 将除去最大元素后的数组重新变成大根堆
            swap(arr, 0, --size);
        }
    }

    /**
     * i节点的父节点：(i - 1) / 2
     * i节点左右节点：i*2 + 1	i*2 + 2
     * 当数组中某节点元素比其父节点大就将这两个数交换，并且下标也交换
     */
    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     * 当堆顶元素与最后一元素交换后，堆顶元素变小了，将这个小元素往下沉
     * 当堆顶元素的左元素不小于堆范围时结束循环
     */
    private static void heapfiy(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
