package algcode.zuo.topic.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class C_StackAndQueueConvert {
	public static void main(String[] args) {}

	/**
	 * 两个栈实现队列
	 */
	public static class TwoStacksQueue {
		private Stack<Integer> push;
		private Stack<Integer> pop;

		public TwoStacksQueue() {
			push = new Stack<>();
			pop = new Stack<>();
		}

		// 添加操作，所有数据添加至push栈中
		public void add(int pushInt) {
			push.push(pushInt);
		}

		// 取数据操作
		public int poll() {
			if (pop.empty() && push.empty()) {
				throw new RuntimeException("队列为空");
			} else if (pop.empty()) {
				while (!push.empty()) {
					pop.push(push.pop());
				}
			}
			return pop.pop();
		}

		public int peek() {
			if (pop.empty() && push.empty()) {
				throw new RuntimeException("队列为空");
			} else if (pop.empty()) {
				while (!push.empty()) {
					pop.push(push.pop());
				}
			}
			return pop.peek();
		}

		public void dao() {
		    if (!pop.empty()) {
		        return;
            }
            while (!push.empty()) {
                pop.push(push.pop());
            }
        }
	}

	/**
	 * 两个队列实现栈
	 *     所有数据添加至data队列中，当需要取数据时，将其余数据全部添加至help队列
	 *     在将两个队列引用交换
	 */
	public static class TwoQueuesStack {
		private Queue<Integer> data;
		private Queue<Integer> help;

		public TwoQueuesStack() {
			data = new LinkedList<>();
			help = new LinkedList<>();
		}

		// 添加操作，所有数据都往data队列中放
		public void push(int pushInt) {
			data.add(pushInt);
		}

		public int peek() {
			if (data.isEmpty()) {
				throw new RuntimeException("栈为空");
			}
			while (data.size() != 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			help.add(res);
			swap();
			return res;
		}

		// 取数据操作
		public int pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("栈为空");
            }
            while (data.size() > 1) { // 只留一个数在data中
                help.add(data.poll());
            }
            int res = data.poll(); // 得到这一个数就是栈结构所弹出的数
            swap(); // 两个队列需要交换引用
            return res;
		}

		private void swap() {
			Queue<Integer> tmp = help;
			help = data;
			data = tmp;
		}
	}
}
