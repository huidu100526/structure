package algcode.brush.array;

/**
 * @auther huidu
 * @create 2019/11/21 14:45
 * @Description: 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinRotateArray {
    public static void main(String[] args) {
        int[] ints = new int[]{3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(ints));
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[1];
        }
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] > array[i + 1]) { // 当前数跟后一个数比较，如果要大返回后一个数
                return array[i + 1];
            } else {
                if (i == array.length - 2) { // 到这说明整个数组是没有旋转的已经排好序的
                    return array[0];
                }
            }
        }
        return 0;
    }
}
