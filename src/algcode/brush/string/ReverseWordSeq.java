package algcode.brush.string;

/**
 * @auther huidu
 * @create 2019/12/8 18:58
 * @Description: 反转单词序列
 * 输入“student. a am I”
 * 正确的句子应该是“I am a student.”
 */
public class ReverseWordSeq {
    public static void main(String[] args) {
        System.out.println(reverseSentence("student. a am I"));
    }

    public static String reverseSentence(String str) {
        str.length();
        if ("".equals(str.trim())) { // 如果传入" "，直接返回
            return str;
        }
        StringBuilder result = new StringBuilder();
        String[] strs = str.split(" ");
        for (int i = strs.length - 1; i >= 0; i--) { // 逆序遍历
            result.append(strs[i]).append(" ");
        }
        return result.toString().trim();
    }
}
