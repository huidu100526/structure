package algcode.zuo.topic.tree;

import java.util.Stack;

public class A_PreInPosTraversal {
	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();

		// unrecursive
		System.out.println("============unrecursive=============");
		preOrderUnRecur(head);
		inOrderUnRecur(head);
		posOrderUnRecur1(head);
		posOrderUnRecur2(head);
	}

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 先序遍历递归
	 * 	   递归版中每一个节点肯定会经过三次，所有第一次就是先序遍历
     * 	   所有第二次就是中序遍历，所有第三次就是后序遍历
	 */
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	/**
	 * 中序遍历递归
	 */
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	/**
	 * 后序遍历递归
	 */
	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}

	/**
	 * 先序遍历（中左右）非递归
	 */
	public static void preOrderUnRecur(Node head) {
		System.out.print("pre-order: ");
        if (head != null) {
			Stack<Node> stack = new Stack<>(); // 准备一个栈
			stack.push(head); // 先将头节点添加到栈
			while (!stack.empty()) {
				head = stack.pop(); // 弹出栈中当前节点
				System.out.print(head.value + " "); // 先输出头节点值
				if (head.right != null) { // 弹出的当前节点有右孩子先添加右孩子
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}

    /**
     * 中序遍历（左中右）非递归
     *     当前节点不为空就压入栈，并且将当前指向节点向左孩子走
     *     当前节点为空就从栈中拿一个出来打印，并且将拿出的节点向右孩子走
     */
	public static void inOrderUnRecur(Node head) {
		System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.empty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
		System.out.println();
	}

    /**
     * 后序遍历（左右中）非递归1
     *     准备两个栈，第一个栈和先序遍历一样，先序是中左右
     *     现在是先存左边元素变成中右左，然后将这些元素按中右左的顺序放入第二个栈中
     *     再将第二个栈依次弹出就是左右中
     */
	public static void posOrderUnRecur1(Node head) {
		System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.empty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack2.push(head.right);
                }
            }
            while (!stack2.empty()) {
                System.out.println(stack2.pop().value + " ");
            }
        }
		System.out.println();
	}

    /**
     * 后序遍历非递归2
     */
	public static void posOrderUnRecur2(Node h) {
		System.out.print("pos-order: ");
		if (h != null) {
			Stack<Node> stack = new Stack<>();
			stack.push(h);
			Node c;
			while (!stack.empty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}
}
