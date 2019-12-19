package algcode.zuo.topic.stack_queue;

public class A_ArrayToStackQueue {
    public static void main(String[] args) {}

    /**
     * 固定数组实现栈
     */
    public static class ArrayStack {
        private Integer[] arr;
        private Integer index;

        // 定义一个栈的大小，index用来标识元素需要添加到的位置
        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("初始化大小不能小于0");
            }
            arr = new Integer[initSize];
            index = 0;
        }

        // 弹出栈顶元素
        public Integer peek() {
            if (index == 0) {
                return null;
            }
            return arr[index - 1];
        }

        // 添加元素，将元素添加至index位置上，后index加一
        public void push(int obj) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("栈已满");
            }
            arr[index++] = obj;
        }

        // 弹出元素，返回index减一位置上的元素
        public Integer pop() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("栈为空");
            }
            return arr[--index];
        }
    }

    /**
     * 固定数组实现队列
     */
    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer start;
        private Integer end;

        // 定义一个队列的大小
        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("初始化大小不能小于0");
            }
            arr = new Integer[initSize];
            size = 0; // 约束队列是否满
            start = 0; // 用来标识需要取出元素的位置
            end = 0; // 用来标识元素需要添加到的位置
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

        // 添加元素，添加至end指向的位置，可以循环走
        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("队列已满");
            }
            size++;
            arr[end] = obj;
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        // 取出元素，将start位置的元素取出，可以循环走
        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("队列为空");
            }
            size--;
            int tmp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[tmp];
        }
    }
}
