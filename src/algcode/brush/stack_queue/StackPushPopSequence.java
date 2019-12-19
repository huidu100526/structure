package algcode.brush.stack_queue;

import java.util.Stack;

/**
 * @auther huidu
 * @create 2019/11/04 10:17
 * @Description: 栈的压入、弹出系列
 * 假设压入栈的所有数字均不相等
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列
 */
public class StackPushPopSequence {
    public static void main(String[] args) {
    }

    /**
     * @param pushA 表示栈的压入顺序的数组
     * @param popA 表示是否可能为pushA栈的弹出顺序的数组
     */
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) { // 遍历一遍压入顺序数组
            stack.push(pushA[i]); // 添加到辅助栈中
            // 只有当栈不为空并且栈顶元素等于弹出顺序数组的第一个元素时，将栈顶元素弹出，并且index加一，再循环判断
            while (!stack.empty() && stack.peek() == popA[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.empty(); // 如果栈为空则说明是正确的
    }
}
