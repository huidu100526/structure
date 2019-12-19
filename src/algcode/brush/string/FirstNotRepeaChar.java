package algcode.brush.string;

/**
 * @auther huidu
 * @create 2019/12/3 17:32
 * @Description: 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstNotRepeaChar {
    public static void main(String[] args) {
    }

    int[] count = new int[256];
    int index = 1;

    public void insert(char ch) {
        if (count[ch] == 0) {
            count[ch] = index++;
        } else {
            count[ch] = -1;
        }
    }

    public char firstAppearingOnce() {
        int temp = Integer.MAX_VALUE;
        char chr = '#';
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0 && count[i] != -1 && count[i] < temp) {
                temp = count[i];
                chr = (char) i;
            }
        }
        return chr;
    }
}
