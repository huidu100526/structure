package algcode.zuo.topic.linklist;

public class F_FindFirstIntersectNode {
    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 两个单链表相交的一系列问题
	 * 单链表可能有环，也可能无环。给定两个单链表的头节点 head1和head2，这两个链表可能相交，也可能不相交
	 * 请实现一个函数，如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null 即可
	 * 要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外空间复杂度请达到 O(1)
	 */
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1); // 链表1第一个相交的节点
		Node loop2 = getLoopNode(head2); // 链表2第一个相交的节点
		if (loop1 == null && loop2 == null) { // 说明是两个无环链表相交
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) { // 说明是两个有环链表相交
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}

	/**
	 * 返回一个链表中第一个入环的节点
	 * 	   一个快指针一个慢指针
	 */
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
        Node n1 = head.next; // 慢指针一次走一步
        Node n2 = head.next.next; // 快指针一次走两步
        while (n1 != n2) { // 快慢指针相遇时跳出
            if (n2.next == null || n2.next.next == null) { // 不相交
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head; // 快指针回到开头
        while (n1 != n2) { // 当快慢指针再次相遇时跳出
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1; // 返回第一个入环的节点
	}

	/**
	 * 找到两个无环链表相交的第一个节点
	 */
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0; // 统计链表长度
        while (cur1.next != null) { // 当跳出时，得到cur1的最后一个节点
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) { // 当跳出时，得到cur2的最后一个节点
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) { // 如果两个链表的最后一个节点不相等不可能相交，返回null
            return null;
        }
        cur1 = n > 0 ? head1 : head2; // cur1表示长链表
        cur2 = cur1 == head1 ? head2 : head1; // cur2表示短链表
        n = Math.abs(n); // 得到两个链表相差的长度
        while (n != 0) { // 长链表先走多出来长度的步数
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) { // 再一起遍历，当相遇时返回相交的节点
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
	}

	/**
	 * 找到两个有环链表相交的第一个节点
	 */
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1;
		Node cur2;
		if (loop1 == loop2) { // 两个链表有公共的环区域，抛开环区域是两个无环链表相交的情况
			cur1 = head1;
			cur2 = head2;
			int n = 0;// 统计链表长度
			while (cur1 != loop1) { // 当遇到入环相交点时跳出，得到cur1的最后一个节点
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) { // 当遇到入环相交点时跳出，得到cur2的最后一个节点
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2; // cur1表示长链表
			cur2 = cur1 == head1 ? head2 : head1; // cur2表示短链表
			n = Math.abs(n); // 得到两个链表相差的长度
			while (n != 0) { // 长链表先走多出来长度的步数
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) { // 再一起遍历，当相遇时返回相交的节点
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
}
