package algcode.zuo.topic.array;

public class A_MaxGap {
    public static void main(String[] args) {
        int[] arr = {34, 32, 64, 12, 22, 43, 13, 24, 78, 56, 41, 6, 10, 20, 89, 67, 56, 45, 34, 12, 10, 3, 59, 33};
        int i = maxGap(arr);
        System.out.println("排序后相邻两个数之间差值最大为：" + i);
    }

    /**
     * 给定一个数组，求排序之后相邻两数的最大差值，要求时间复杂度O(N)
     * 借用桶排序概念的基于比较的排序
     *     最大差值出现在每一个桶的最大值和其下一个非空桶的最小值的差值
     */
    private static int maxGap(int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1]; // 保存该桶是否为非空桶，非空桶为true
        int[] mins = new int[len + 1]; // 保存每个桶中的最小值
        int[] maxs = new int[len + 1]; // 保存每个桶中的最大值
        int bid;
        for (int num : nums) {
            bid = bucket(num, len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], num) : num;
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], num) : num;
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i < len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    /**
     * 有最大最小值，一个给定长度，得到给定数应该在桶的什么位置
     */
    private static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
