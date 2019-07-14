package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Songxc
 * @Date: 10:03 2019/7/14
 * @Description: 括号生成
 *  给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 *   思路：
 *   1）暴力破解法  时间复杂度 0(2^2n * n)  空间复杂度 0(2^2n * n)
 *   2） 回溯法   时间复杂度 0(4^n / sqrt(n))   空间复杂度 0(4^n / sqrt(n))
 *      回溯的过程确定（和）的数量，进行下一步的回溯拼接操作
 *   3） 闭合数  时间复杂度 0(4^n / sqrt(n))   空间复杂度 0(4^n / sqrt(n))
 */
public class T22_Parenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backTrace(ans, "" , 0, 0, n);
        return ans;
    }

    public void backTrace(List<String> ans, String cur, int open, int close, int max){
        if(cur.length() == max * 2){
            ans.add(cur);
            return;
        }
        if(open<max){
            backTrace(ans, cur+"(", open+1, close, max);
        }
        if(close < open){
            backTrace(ans, cur+")", open, close+1, max);
        }
    }
}
