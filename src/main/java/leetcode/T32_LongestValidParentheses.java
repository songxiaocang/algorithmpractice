package leetcode;

/**
 * @Author: Songxc
 * @Date: 15:40 2019/7/14
 * @Description: 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 思路：
 * 方法                    时间复杂度         空间复杂度
 * 1） 暴力破解法           0(n2)              0(n)
 * 2） 动态规划             0(n)               0(n)
 * 3）栈                    0(n)               0(n)
 * 4） 两个中间变量          0(n)               0(1)
 */
public class T32_LongestValidParentheses {
    //动态规划
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int maxVal = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if ((i - dp[i - 1]) > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                if (dp[i] > maxVal) {
                    maxVal = dp[i];
                }
            }
        }
        return maxVal;
    }

    //中间变量
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0, maxVal = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxVal = Math.max(maxVal, 2 * right);
            }
            if (right > left) {
                left = right = 0;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxVal = Math.max(maxVal, 2 * left);
            }
            if (left > right) {
                left = right = 0;
            }
        }
        return maxVal;
    }
}
