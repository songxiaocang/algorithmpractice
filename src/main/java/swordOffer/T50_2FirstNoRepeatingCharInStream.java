package swordOffer;

/**
 * @Author: Songxc
 * @Date: 21:56 2019/6/15
 * @Description:  字符流中第一个只出现一次的字符
 *  思路：
 *   使用哈希表（数组），数组索引保存ASCII字符，值为每个字符在字符输入流中的位置
 */
public class T50_2FirstNoRepeatingCharInStream {
    public static class CharStatistics {
        private int index;
        private int[] times;

        public CharStatistics() {
            index = 0;
            times = new int[256];
            for (int i = 0; i < 256; i++) {
                times[i] = -1;
            }
        }

        public void insert(char ch) {
            if (times[ch] == -1) {
                times[ch] = index;
            } else {
                times[ch] = -2;
            }
            index++;
        }

        public char find() {
            int minIndex = 256;
            char ret = '\77';
            for (int i = 0; i < 256; i++) {
                if (times[i] >= 0 && times[i] < minIndex) {
                    minIndex = times[i];
                    ret = (char) i;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        String str = "google";
        CharStatistics charStatistics = new CharStatistics();
        for (int i = 0; i < str.length(); i++) {
            charStatistics.insert(str.charAt(i));
            System.out.print(charStatistics.find() + " ");
        }
    }
}
