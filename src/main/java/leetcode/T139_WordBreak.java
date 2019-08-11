package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Songxc
 * @Date: 19:50 2019/8/11
 * @Description: 单词拆分
 *  思路：
 *  给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 *     拆分时可以重复使用字典中的单词。
 *     你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 *
 * 思路：
 *  动态规划
 *   时间复杂度度为：0（n2）， 空间复杂度为0（n）
 *    使用dp数组记录以当前遍历节点结尾的子字符串是否满足在字典中。
 *   迭代遍历源字符串，依次更新dp数组值，直到字符串结束。
 */
public class T139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() <= 0) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> wordDictSet = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
