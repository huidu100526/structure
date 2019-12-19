package algcode.brush.array;

/**
 * @auther huidu
 * @create 2019/11/30 18:25
 * @Description: 连续子数组的最大和
 * {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和
 * 每一个元素与下一个元素相加进行比较，较大的保留
 */
public class ContinSubArrayMaxSum {
    public static void main(String[] args) {
        int[] ints = new int[]{6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(findGreatestSumOfSubArray(ints));
    }

    public static int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int num;
        int max = array[0]; // 先使用第一个作为最大值
        for (int i = 0; i < array.length; i++) {
            num = 0; // 先遍历一遍，每次遍历重新回到0，为了使所有连续的情况都被计算
            for (int j = i; j < array.length; j++) { // 遍历一遍进行累加判断
                num += array[j]; // 外层第一遍是从第一个数开始累加连续数组，第二遍是从第二个开始累加连续数组...
                if (max < num) max = num; // 保存累加后的值的最大值
            }
        }
        return max;
    }
}
