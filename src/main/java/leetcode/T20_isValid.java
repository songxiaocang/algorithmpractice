package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 12:39 2019/7/14
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 *  思路：
 *   辅助栈匹配
 *   时间复杂度 0(n)  空间复杂度 0(n)
 */
public class T20_isValid {
    Map<Character, Character> map = new HashMap<Character, Character>(){{
        put('}','{');
        put(']','[');
        put(')','(');
    }};

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char val = s.charAt(i);
            if(map.containsKey(val)){
                char topVal = stack.isEmpty()?'#':stack.pop();
                if(topVal != map.get(val)){
                    return false;
                }
            }else{
                stack.push(val);
            }

        }

        return stack.isEmpty();
    }
}
