package algcode.brush.tree;

import java.util.Arrays;

/**
 * @auther huidu
 * @create 2019/12/5 19:31
 * @Description: 重建二叉树
 * 输入某二叉树的前序和中序遍历的结果，请重建出该二叉树。假设输入的前序和中序遍历的结果中都不含重复数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 过程：
 *     根据前序序列第一个结点确定根结点
 *     根据根结点在中序序列中的位置分割出左右两个子序列
 *     对左子树和右子树分别递归使用同样的方法继续分解
 */
public class ReconBinaryTree {
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

    public TreeNode reBinTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]); // 树的根节点
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) { // 在中序数组中找到树的根
                // 左子树递归，因为pre第一个是根，所以从1开始到i+1作为前序，而in第i个是根，所以从0开始到i作为中序
                root.left = reBinTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树递归，copyOfRange 函数，左闭右开
                root.right = reBinTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }
}
