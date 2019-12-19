package algcode.brush.linklist;

/**
 * @auther huidu
 * @create 2019/12/3 17:23
 * @Description: 合并两个有序链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoSortList {
    public static void main(String[] args) {
    }

    public class ListNode {
        int value;
        ListNode next = null;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p = list1;
        ListNode q = list2;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (p != null && q != null) {
            if (p.value < q.value) {
                tail.next = p;
                tail = p;
                p = p.next;
            } else {
                tail.next = q;
                tail = q;
                q = q.next;
            }
        }
        if (p != null) {
            tail.next = p;
        }
        if (q != null) {
            tail.next = q;
        }
        return head.next;
    }
}
