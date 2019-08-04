package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Songxc
 * @Date: 17:45 2019/8/4
 * @Description:  最小覆盖字串
 *  给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 说明：
 *
 *     如果 S 中不存这样的子串，则返回空字符串 ""。
 *     如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 *
 *  思路：
 *   滑动窗口
 *    双指针法。
 *    时间复杂度为0（m+n）  空间复杂度为0（m+n）
 */
public class T76_MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || s.length() <= 0 || t == null || t.length() <= 0) {
            return "";
        }

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = needs.getOrDefault(t.charAt(i), 0);
            needs.put(t.charAt(i), count + 1);
        }

        int left = 0, right = 0, match = 0, start = 0, minLen = -1;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (needs.containsKey(c)) {
                int count = windows.getOrDefault(c, 0);
                windows.put(c, count + 1);

                if (needs.get(c).intValue() == windows.get(c).intValue()) {
                    match++;
                }
            }


            while (left <= right && match == needs.size()) {
                if (minLen == -1 || right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    windows.put(c2, windows.get(c2) - 1);

                    if (windows.get(c2).intValue() < needs.get(c2).intValue()) {
                        match--;
                    }

                }
                left++;

            }
            right++;
        }

        return minLen == -1 ? "" : s.substring(start, start + minLen);


    }
}
