package algcode.brush.math;

/**
 * @auther huidu
 * @create 2019/11/30 18:53
 * @Description: 整数中出现1的次数
 * 1~13中包含1的数字有1、10、11、12、13因此共出现6次1
 * 求 1 到 n 中1出现的次数
 */
public class OneFrequency {
    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN(13));
    }

    public static int numberOf1Between1AndN(int n) {
        int count = 0;
        while (n > 0) { // 求 1 到 n 的
            char[] chars = String.valueOf(n).toCharArray();
            for (char c : chars) {
                if (c == '1') count++; // 一个数中包含1就统计
            }
            n--;
        }
        return count;
    }
}
