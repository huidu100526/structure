package algcode.brush.recursive;

/**
 * @auther huidu
 * @create 2019/11/21 14:57
 * @Description: 跳台阶和变态跳台阶
 */
public class JumpFloor {
    public static void main(String[] args) {
        System.out.println(jumpFloorI(6));
        System.out.println(jumpFloorII(6));
    }

    /**
     * 跳台阶
     *     一只青蛙一次可以跳上1级台阶，也可以跳上2级
     *     求该青蛙跳上一个n级的台阶总共有多少种跳法(先后次序不同算不同的结果)
     */
    public static int jumpFloorI(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return jumpFloorI(n - 1) + jumpFloorI(n - 2);
        }
    }

    /**
     * 变态跳台阶
     *     一只青蛙一次可以跳上1级台阶，也可以跳上2级 ... 它也可以跳上n级
     *     求该青蛙跳上一个n级的台阶总共有多少种跳法
     */
    public static int jumpFloorII(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return 2 * jumpFloorII(n - 1);
        }
    }
}
