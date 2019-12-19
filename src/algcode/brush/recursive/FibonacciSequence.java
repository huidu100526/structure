package algcode.brush.recursive;

/**
 * @auther huidu
 * @create 2019/11/21 14:57
 * @Description: 斐波那契数列
 * 斐波那契数列1、1、2、3、5、8、13，现在要求输入一个整数n，请你输出斐波那契数列的第n项(从0开始，第0项为0)
 * n<=39
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(fibonacciDiGui(11));
        System.out.println(fibonacci(11));
    }

    // 递归
    public static int fibonacciDiGui(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciDiGui(n - 1) + fibonacciDiGui(n - 2); // 前一项加上前两项
    }

    //非递归
    public static int fibonacci(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res = res + pre;
            pre = temp;
        }
        return res;
    }
}
