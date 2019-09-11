package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Songxc
 * @Date: 19:56 2019/9/8
 * @Description: 找到字符串中的所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *     字母异位词指字母相同，但排列不同的字符串。
 *     不考虑答案输出的顺序。
 *
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 *
 *  解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 *
 * 思路：
 *  滑动窗口：
 *   高级双指针。
 *    时间复杂度为0(n)   n为匹配字符串p的长度
 *    空间复杂度为0(n)   n为匹配字符串p对应长度所产生的空间消耗
 *
 */
public class T438_FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] p_letter = new int[26];
        for (int i = 0; i < p.length(); i++) {//记录p里面的数字分别有几个
            p_letter[p.charAt(i) - 'a']++;
        }
        int start = 0;
        int end = 0;
        int[] between_letter = new int[26];//记录两个指针之间的数字都有几个
        while (end < s.length()) {
            int c = s.charAt(end++) - 'a';//每一次拿到end指针对应的字母
            between_letter[c]++;//让这个字母的数量+1

            //如果这个字母的数量比p里面多了,说明这个start坐标需要排除
            while (between_letter[c] > p_letter[c]) {
                between_letter[s.charAt(start++) - 'a']--;
            }
            if (end - start == p.length()) {
                result.add(start);
            }
        }
        return result;


    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
