package algcode.brush.math;

/**
 * @auther huidu
 * @create 2019/12/6 19:38
 * @Description: 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 */
public class Money {
    public static void main(String[] args) {
        int[] ints = new int[]{4, 6};
        System.out.println(coinChange(ints, 32));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1]; // 准备一个总金额加一容量的数组
        result[0] = 0;
        for (int i = 1; i <= amount; i++) { // 遍历金额大小
            int max = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                // 统计币值数所在的数组位置的
                if (i - coins[j] >= 0 && result[i - coins[j]] != Integer.MAX_VALUE) {
                    max = Math.min(max, result[i - coins[j]] + 1);
                }
            }
            result[i] = max; // 将币值数
        }
        return result[amount] == Integer.MAX_VALUE ? -1 : result[amount];
    }
}
