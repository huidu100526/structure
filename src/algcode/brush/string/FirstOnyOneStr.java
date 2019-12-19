package algcode.brush.string;

/**
 * @auther huidu
 * @create 2019/12/8 16:06
 * @Description: 第一次只出现一次的字符串
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstOnyOneStr {
    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("GooGlle"));
    }

    public static int firstNotRepeatingChar(String str) {
        StringBuffer sb = new StringBuffer();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            sb.append(c);
        }
        for (int i = 0; i < chars.length; i++) {
            // 通过比较正反数过来的索引值是否相等来确定是否只出现一次
            if (sb.indexOf(chars[i] + "") == sb.lastIndexOf(chars[i] + "")) {
                return i;
            }
        }
        return -1;
    }
}
