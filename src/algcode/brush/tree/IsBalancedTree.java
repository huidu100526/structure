package algcode.brush.tree;

/**
 * @auther huidu
 * @create 2019/12/1 17:10
 * @Description: 判断二叉树是否是平衡二叉树
 */
public class IsBalancedTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        System.out.println(isBalance(head));
    }

    public static class TreeNode {
        public int value;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static boolean isBalance(TreeNode head) {
        if (head == null) {
            return true;
        }
        if (Math.abs(getHeight(head.left) - getHeight(head.right)) > 1) {
            return false;
        }
        return isBalance(head.left) && isBalance(head.right);
    }

    public static int getHeight(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return ((getHeight(head.left) > getHeight(head.right)) ? getHeight(head.left) : getHeight(head.right)) + 1;
    }
}