package algcode.zuo.topic.stack_queue;

import java.util.Stack;

public class B_GetMinStack {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(3);
		System.out.println(stack.getMin());
		stack.push(4);
		System.out.println(stack.getMin());
		stack.push(1);
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.getMin());
	}

	/**
	 * 实现栈的基本功能基础上，再实现返回栈中最小元素的操作，使用现成的栈结构
	 * pop()、push()、getMin()操作的时间复杂度都为O(1)
	 * 	    准备两个栈，数据往data栈中添加，同时往min栈添加，min栈栈顶元素记录最小值
	 * 	    当添加的值比min栈栈顶数小，就往min栈添加小值数
	 * 	    当添加的值比min栈栈顶数大，就往min栈添加一次min栈栈顶元素来记录最小值
	 */
	public static class MyStack {
		private Stack<Integer> data;
		private Stack<Integer> min;

		public MyStack() {
			data = new Stack<>();
			min = new Stack<>();
		}

		// 添加数据功能
		public void push(int value) {
			data.push(value); // 所有数都往data栈中放
			if (min.empty()) {
			    min.push(value); // 如果min栈为空就添加第一个数
            } else if (value < getMin()) {
			    min.push(value); // 如果添加的值比min栈栈顶数小，就往min栈添加小值数
            } else {
			    min.push(getMin()); // 如果添加的值比min栈栈顶数大，就往min栈添加一次min栈栈顶元素来记录最小值
            }
		}

		// 弹出数据功能
        public int pop() {
		    if (data.empty()) {
                throw new RuntimeException("栈为空");
            }
            min.pop(); // min栈数根data栈数同步
		    return data.pop();
        }

		// getMin()功能
		public int getMin() {
			if (min.empty()) {
                throw new RuntimeException("栈为空");
			}
			return min.peek();
		}
	}
}
