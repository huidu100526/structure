package algcode.brush.recursive;

/**
 * @auther huidu
 * @create 2019/12/3 16:54
 * @Description: 矩形覆盖
 * 可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 */
public class RectangleCover {
    public static void main(String[] args) {
        System.out.println(rectCoverDiGui(8));
        System.out.println(rectCover(8));
    }

    // 递归
    public static int rectCoverDiGui(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return rectCoverDiGui(target - 1) + rectCoverDiGui(target - 2);
        }
    }

    // 非递归
    public static int rectCover(int target) {
        int a = 0;
        int b = 1;
        int temp = 1;
        while(target-- > 0){
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
