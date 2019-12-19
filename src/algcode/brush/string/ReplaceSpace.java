package algcode.brush.string;

/**
 * @auther huidu
 * @create 2019/11/21 14:55
 * @Description: 替换空格
 * 将一个字符串中的每个空格替换成“%20”
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(stringBuffer));
    }

    public static String replaceSpace(StringBuffer str) {
        String string = str.toString();
        if (string.length() < 1) {
            return string;
        }
        StringBuffer intoChar = new StringBuffer();
        char[] chars = string.toCharArray(); // 转换为字符数组
        for (char c : chars) {
            if (c == ' ') {
                intoChar.append("%20");
            } else {
                intoChar.append(c);
            }
        }
        return intoChar.toString();
    }
}
