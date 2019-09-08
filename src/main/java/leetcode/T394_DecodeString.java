package leetcode;

import java.util.LinkedList;

/**
 * @Author: Songxc
 * @Date: 11:22 2019/9/8
 * @Description: 字符串解码
 *  给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 *
 * 思路；
 *  辅助链表法
 *   时间复杂度0（n）
 *   空间复杂度0（n）  辅助栈在极端情况下需要线性空间
 */
public class T394_DecodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Integer multi = 0;
        LinkedList<Integer> multiList = new LinkedList<>();
        LinkedList<String> resList = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                multiList.add(multi);
                resList.add(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                Integer curMulti = multiList.removeLast();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < curMulti; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(resList.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + (c - '0');
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
