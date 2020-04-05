package stringSubject;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 20:35 2020/4/5
 * @Description: 括号匹配
 *  思路：
 *      栈
 */
public class StringMatch {
    public static boolean stringMatch(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char c2 = stack.pop();
                if (c == '}' && c2 != '{') {
                    return false;
                }
                if (c == ']' && c2 != '[') {
                    return false;
                }
                if (c == ')' && c2 != '(') {
                    return false;
                }
            }

            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(stringMatch("()[]"));
        System.out.println(stringMatch("([)]"));
        System.out.println(stringMatch("{[]}"));
        System.out.println(stringMatch("{[]()()}"));
    }
}
