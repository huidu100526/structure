package algcode.brush.array;

import java.util.ArrayList;

/**
 * @auther huidu
 * @create 2019/11/21 15:51
 * @Description: 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class ArrayToMinNum {
    public static void main(String[] args) {
        int[] ints = new int[]{3, 32, 321};
        System.out.println(printMinNumber(ints));
    }

    public static String printMinNumber(int[] numbers) {
        if (numbers.length == 1) {
            return String.valueOf(numbers[0]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]); // 将数组放入arrayList中
        }
        // 比较器比较后进行排序
        list.sort((str1, str2) -> (str1 + "" + str2).compareTo(str2 + "" + str1));

        for (int x : list) {
            stringBuilder.append(x);
        }
        return stringBuilder.toString();
    }
}
