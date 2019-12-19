package algcode.brush.linklist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @auther huidu
 * @create 2019/12/3 17:13
 * @Description: 从尾到头打印链表
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class TailToHeadPrintList {
    public static void main(String[] args) {
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public ArrayList printListFromTailToHead(Node listNode) {
        ArrayList<Integer> arrlist = new ArrayList<>(); // 准备结果
        if (listNode == null) {
            return arrlist;
        }
        Stack<Integer> stack = new Stack<>(); // 准备一个栈
        while (listNode != null) {
            stack.push(listNode.value); // 遍历链表，将链表每一个节点添加到栈中
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrlist.add(stack.pop()); // 再依次将栈中的数据添加到结果中
        }
        return arrlist;
    }
}
