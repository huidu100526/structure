package algcode.brush.tree;

import java.util.ArrayList;

/**
 * @auther huidu
 * @create 2019/12/6 18:49
 * @Description: 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class TopToDownPrintTree {
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

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>(); // 结果列表
        ArrayList<TreeNode> helpList = new ArrayList<>(); // 辅助列表
        if (root == null) {
            return list;
        }
        helpList.add(root); // 先将头节点添加到辅助列表
        while (helpList.size() != 0) {
            TreeNode temp = helpList.remove(0); // 移除辅助列表中的值，返回为一个节点
            list.add(temp.value); // 将这个节点的值添加到结果列表中
            if (temp.left != null) {
                helpList.add(temp.left); // 先添加头节点的左孩子，下次循环时就会将这个节点添加到结果列表中
            }
            if (temp.right != null) {
                helpList.add(temp.right); // 后添加头节点的右孩子
            }
        }
        return list;
    }
}
