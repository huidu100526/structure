package algcode.brush.array;

/**
 * @auther huidu
 * @create 2019/11/21 15:22
 * @Description: 数组中第一个重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class FirstRepeatNumInArray {
    public static void main(String[] args) {
        int[] ints = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate(ints, ints.length).toString());
    }

    /**
     * @param numbers 数组
     * @param length 数组长度
     */
    public static Integer duplicate(int[] numbers, int length) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length ; i++) {
            stringBuffer.append(numbers[i]);
        }
        for (int i = 0; i < length ; i++) {
            // 如果这个数前后数过来的结果不一样，则说明存在重复的数
            if (stringBuffer.indexOf(numbers[i] + "") != stringBuffer.lastIndexOf(numbers[i] + "")) {
                return numbers[i];
            }
        }
        return 0;
    }
}
