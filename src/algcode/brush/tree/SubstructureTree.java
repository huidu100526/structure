package algcode.brush.tree;

/**
 * @auther huidu
 * @create 2019/12/6 16:48
 * @Description: 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class SubstructureTree {
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

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }
        return doTree1HasTree2(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    public boolean doTree1HasTree2(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.value != tree2.value) {
            return false;
        }
        return doTree1HasTree2(tree1.left, tree2.left) && doTree1HasTree2(tree1.right, tree2.right);
    }
}