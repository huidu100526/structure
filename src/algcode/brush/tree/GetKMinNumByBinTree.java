package algcode.brush.tree;

import java.util.ArrayList;

/**
 * @auther huidu
 * @create 2019/12/8 15:21
 * @Description: 二叉搜索树的第k个节点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class GetKMinNumByBinTree {
    public static void main(String[] args) {
    }

    public static class TreeNode {
        public int value;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode kthNode(TreeNode root, int k) {
        addNode(root); // 将中序遍历的结果存放至list中
        if (k >= 1 && list.size() >= k) {
            return list.get(k - 1); // 直接返回第k小的节点值
        }
        return null;
    }

    // 中序遍历，二叉搜索树的中序遍历就是树节点值的递增排列
    void addNode(TreeNode node) {
        if (node != null) {
            addNode(node.left);
            list.add(node);
            addNode(node.right);
        }
    }
}
