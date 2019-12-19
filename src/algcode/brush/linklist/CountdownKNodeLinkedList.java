package algcode.brush.linklist;

/**
 * @auther huidu
 * @create 2019/11/23 15:54
 * @Description: 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class CountdownKNodeLinkedList {
    public static void main(String[] args) {
    }

    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int data) {
            this.value = data;
        }
    }

    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode node = head;
        int n = 0;
        while (node != null) {
            n++; // 遍历一遍链表统计链表长度
            node = node.next;
        }
        if (n < k) { // 保证k在链表长度范围内
            return null;
        }
        node = head;
        for (int i = 0; i < n - k; i++) { // 只遍历到倒数第k个节点
            node = node.next;
        }
        return node;
    }
}