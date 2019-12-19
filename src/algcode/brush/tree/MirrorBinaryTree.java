package algcode.brush.tree;

/**
 * @auther huidu
 * @create 2019/12/6 16:59
 * @Description: 二叉树的镜像
 * 二叉树的镜像定义：
 * 源二叉树：            镜像二叉树：
 *     	     8                        8
 *     	   /  \                     /  \
 *     	  6   10                   10   6
 *     	 / \  / \                 / \  / \
 *      5  7 9  11              11  9 7  5
 */
public class MirrorBinaryTree {
    public static void main(String[] args) {
    }

    public class TreeNode {
        public int value;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            return;
        }
        // 交换左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 递归遍历左右子树进行交换
        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }
    }
}
