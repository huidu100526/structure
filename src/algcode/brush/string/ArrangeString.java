package algcode.brush.string;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @auther huidu
 * @create 2019/11/04 10:56
 * @Description: 字符串的排序
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 */
public class ArrangeString {
    public static void main(String[] args) {
        ArrayList<String> abc = permutation("abc");
        System.out.println(abc.toString());
    }

    public static ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() < 1) {
            return list;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> treeSet = new TreeSet<>();
        permutation(chars, 0, treeSet);
        list.addAll(treeSet);
        return list;
    }

    public static void permutation(char[] chars, int begin, TreeSet<String> treeSet) {
        if (chars == null || begin < 0 || begin > chars.length - 1) {
            return;
        }
        if (begin == chars.length - 1) {
            treeSet.add(String.valueOf(chars));
        } else {
            for (int i = begin; i <= chars.length - 1; i++) {
                swap(chars, begin, i);
                permutation(chars, begin + 1, treeSet);
                swap(chars, begin, i);
            }
        }
    }

    public static void swap(char[] chars, int a, int b) {
        char t = chars[a];
        chars[a] = chars[b];
        chars[b] = t;
    }
}
