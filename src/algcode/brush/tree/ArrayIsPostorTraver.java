package algcode.brush.tree;

/**
 * @auther huidu
 * @create 2019/12/8 14:37
 * @Description: 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class ArrayIsPostorTraver {
    public static void main(String[] args) {
    }

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] seq, int start, int end) {
        if (start == end) {
            return true;
        }
        int root = seq[end]; // 数组最后一个数即根节点
        int left = start;
        while (left < end && seq[left] < root) {
            left++; // 此循环即统计出根节点的左子树共有多少个节点
        }
        for (int i = left; i < end; i++) {
            if (seq[i] < root) { // 左子树节点后的节点如果有大于根节点的则不是后序遍历
                return false;
            }
        }
        // 递归每一棵子树
        return isBST(seq, start, left - 1) && isBST(seq, left, end - 1);
    }
}
