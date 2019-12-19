package algcode.zuo.topic.tree;

public class E_IsBalancedTree {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isBalance(head));
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
     * 判断一棵二叉树是否为平衡二叉树
     *     任意节点的左子树跟右子树的高度差不超过1的树就为平衡二叉树
     */
	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}

	public static int getHeight(Node head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		int lH = getHeight(head.left, level + 1, res); // 左子树高度
		if (!res[0]) {
			return level;
		}
		int rH = getHeight(head.right, level + 1, res); // 右子树高度
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lH - rH) > 1) { // 如果高度差大于1变为false
			res[0] = false;
		}
		return Math.max(lH, rH);
	}
}
