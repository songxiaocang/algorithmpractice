package leetcode;

import java.util.*;

/**
 * @Author: Songxc
 * @Date: 1:31 2019/7/29
 * @Description: 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * <p>
 * 思路：
 * 有两种方法：
 * 1）排序数组分类
 * 2）按计数分类
 */
public class T49_GroupAnagrams {
    //方法1 排序字符串作为key  时间复杂度为O(nlogk) 空间复杂度为O(nk)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String newStr = String.valueOf(arr);

            if (!res.containsKey(newStr)) {
                res.put(newStr, new ArrayList<>());
            }
            res.get(newStr).add(str);
        }

        return new ArrayList<>(res.values());
    }

    //方法2  转换为字母出现次数拼接字符串作为key 时间复杂度为O(nk) 空间复杂度为O(nk)
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
