package algcode.brush.math;

/**
 * @auther huidu
 * @create 2019/11/30 16:49
 * @Description: 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
 * 当 exponent>0 时，直接相乘 exponent 次数
 * 当 exponent<0 时，先将 exponent 变为正整数，再直接相乘 exponent 次数，最后在转换为double类型
 * 当 exponent=0 时，直接返回 -1
 */
public class NumberPower {
    public static void main(String[] args) {
        System.out.println(power(2.0, -2));
    }

    public static double power(double base, int exponent) {
        double temp = 1;
        if (exponent > 0) { // 当幂数为正时
            for (int i = 1; i <= exponent; i++) { // 循环幂次数
                temp = temp * base;
                if (temp > Double.MAX_VALUE) return -1;
            }
            return temp;
        } else if (exponent < 0) { // 当幂数为负时
            exponent = -exponent;
            for (int i = 1; i <= exponent; i++) {
                temp = temp * base;
                if (temp > Double.MAX_VALUE) return -1;
            }
            temp = 1.0 / temp; // 将其倒数
            return temp;
        } else {
            return -1;
        }
    }
}
