package leetcode;

/**
 * @Author: Songxc
 * @Date: 23:30 2019/9/13
 * @Description: 回文子串
 *  给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 *
 * 思路：
 *  1）中心扩散法  时间复杂度为0（n2）
 *  2）动态规划   时间复杂度为0（n2）
 */
public class T647_CountSubStrings {
    //中心扩散法
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            //以当前点i位置，向两边扩展,以i i+1位置向两边扩展
            result += countSegment(s, i, i);
            result += countSegment(s, i, i + 1);
        }
        return result;
    }


    public int countSegment(String s, int start, int end) {
        int count = 0;
        //start往左边跑，end往右边跑，注意边界
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
            count++;
        }
        return count;
    }

    //动态规划
    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        boolean[][] dp = buildDPForCountSubstrings(s);
        for (int j = 0; j < dp.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (dp[i][j]) {
                    result++;
                }
            }
        }
        return result;
    }


    private boolean[][] buildDPForCountSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //注意i 和j 的边界，只计算上半部分，j - i <= 1是为了处理边界，dp[i + 1][j - 1]是dp[i][j]砍头去尾后的是否是回文
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1]);
                }
            }
        }
        return dp;
    }

}
