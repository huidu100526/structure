package algcode.zuo.topic.tree;

public class G_CompleteTreeNodeNumber {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));
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
     * 已知一棵完全二叉树，求其节点的个数
     * 要求：时间复杂度低于O(N)，N为这棵树的节点个数
     * 1 << (height - lever)
     *     2的(height - lever)次方
     */
	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
        int height = mostLeftLevel(head, 1);
        return bs(head, 1, height);
	}

	public static int bs(Node node, int lever, int height) {
		if (lever == height) {
			return 1;
		}
		if (mostLeftLevel(node.right, lever + 1) == height) {
			return (1 << (height - lever)) + bs(node.right, lever + 1, height);
		} else {
			return (1 << (height - lever - 1)) + bs(node.left, lever + 1, height);
		}
	}

    /**
     * 得到完全二叉树的高度
     */
	public static int mostLeftLevel(Node node, int height) {
		while (node != null) {
            height++;
			node = node.left;
		}
		return height - 1;
	}
}
