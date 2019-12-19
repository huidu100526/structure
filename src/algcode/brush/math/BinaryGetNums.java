package algcode.brush.math;

/**
 * @auther huidu
 * @create 2019/12/3 16:46
 * @Description: 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class BinaryGetNums {
    public static void main(String[] args) {
        System.out.println(numberOf1(9));
    }

    public static int numberOf1(int n) {
        int count = 0;
        char[] chars = Integer.toBinaryString(n).toCharArray(); // 将输入的数转换为二进制再转换为字符数组
        for (char c : chars) {
            if (c == '1') count++; // 如果包含1，进行统计
        }
        return count;
    }
}
