package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Songxc
 * @Date: 23:21 2019/8/27
 * @Description: 删除无效的括号
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 *
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 *
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 *
 * 示例 2:
 *
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 *
 * 思路：
 *  有两种解法
 *  1） 回溯
 *  时间复杂度：O(2^N)。因为在最坏的情况下，表达式中只有左括号，对于每个括号，我们都有两个选项，即是删除还是考虑它。考虑到表达式有 N 括号，时间复杂性将为O(2^N)。
 * 空间复杂度：O(N)，因为我们使用的是递归解决方案，对于递归解决方案，在递归过程中，始终有堆栈空间用作内部函数状态保存到堆栈中。递归的最大深度决定了所使用的堆栈空间。因为我们一次处理一个字符，而递归的基本情况是当我们处理完表达式字符串的所有字符时，堆栈的大小将为 O(n)。注意，我们不考虑存储有效表达式所需的空间。我们只计算中间过程的空间。
 *
 *  2） 有限回溯
 *      递归的状态现在由五个不同的变量定义：
 *
 *     index 它表示我们必须在原始字符串中处理的当前字符。
 *     left_count 它表示添加到我们正在构建的表达式中的左括号数。
 *     right_count 它表示添加到我们正在构建的表达式中的右括号数。
 *     left_rem 是要删除的左括号数。
 *     right_rem 表示保留要删除的右括号数。总的来说，为了使最终表达式有效，left_rem == 0 和 right_rem == 0。
 *
 * 时间复杂度：我们所执行的优化只是一种更好的修剪形式。在最坏的情况下，我们可以有 ((((((((( 和 left_rem = len(S) 和在这种情况下我们可以丢弃所有字符，因为所有字符都放错了位置。在最坏的情况下，每个括号中仍然有两个选项，这给了我们 O(2^n) 的复杂性。
 * 空间复杂度：空间复杂性与以前的解决方案保持相同，即 O(N)。 在到达基本情况之前，我们必须达到 N 的最大递归深度。注意，我们不考虑存储有效表达式所需的空间。我们只计算中间过程空间。
 *
 *
 */
public class T301_RemoveInvalidParentheses {
    //方法1： 回溯
    private Set<String> validExpressions = new HashSet<String>();
    private int minimumRemoved;

    private void reset() {
        this.validExpressions.clear();
        this.minimumRemoved = Integer.MAX_VALUE;
    }

    private void recurse(
            String s,
            int index,
            int leftCount,
            int rightCount,
            StringBuilder expression,
            int removedCount) {

        // If we have reached the end of string.
        if (index == s.length()) {

            // If the current expression is valid.
            if (leftCount == rightCount) {

                // If the current count of removed parentheses is <= the current minimum count
                if (removedCount <= this.minimumRemoved) {

                    // Convert StringBuilder to a String. This is an expensive operation.
                    // So we only perform this when needed.
                    String possibleAnswer = expression.toString();

                    // If the current count beats the overall minimum we have till now
                    if (removedCount < this.minimumRemoved) {
                        this.validExpressions.clear();
                        this.minimumRemoved = removedCount;
                    }
                    this.validExpressions.add(possibleAnswer);
                }
            }
        } else {

            char currentCharacter = s.charAt(index);
            int length = expression.length();

            // If the current character is neither an opening bracket nor a closing one,
            // simply recurse further by adding it to the expression StringBuilder
            if (currentCharacter != '(' && currentCharacter != ')') {
                expression.append(currentCharacter);
                this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
                expression.deleteCharAt(length);
            } else {

                // Recursion where we delete the current character and move forward
                this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
                expression.append(currentCharacter);

                // If it's an opening parenthesis, consider it and recurse
                if (currentCharacter == '(') {
                    this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                } else if (rightCount < leftCount) {
                    // For a closing parenthesis, only recurse if right < left
                    this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                }

                // Undoing the append operation for other recursions.
                expression.deleteCharAt(length);
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {

        this.reset();
        this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
        return new ArrayList(this.validExpressions);
    }


    //方法2：有限的回溯
    private Set<String> validExpressions2 = new HashSet<String>();

    private void recurse2(
            String s,
            int index,
            int leftCount,
            int rightCount,
            int leftRem,
            int rightRem,
            StringBuilder expression) {

        // If we reached the end of the string, just check if the resulting expression is
        // valid or not and also if we have removed the total number of left and right
        // parentheses that we should have removed.
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                this.validExpressions2.add(expression.toString());
            }

        } else {
            char character = s.charAt(index);
            int length = expression.length();

            // The discard case. Note that here we have our pruning condition.
            // We don't recurse if the remaining count for that parenthesis is == 0.
            if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
                this.recurse2(
                        s,
                        index + 1,
                        leftCount,
                        rightCount,
                        leftRem - (character == '(' ? 1 : 0),
                        rightRem - (character == ')' ? 1 : 0),
                        expression);
            }

            expression.append(character);

            // Simply recurse one step further if the current character is not a parenthesis.
            if (character != '(' && character != ')') {

                this.recurse2(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);

            } else if (character == '(') {

                // Consider an opening bracket.
                this.recurse2(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);

            } else if (rightCount < leftCount) {

                // Consider a closing bracket.
                this.recurse2(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
            }

            // Delete for backtracking.
            expression.deleteCharAt(length);
        }
    }

    public List<String> removeInvalidParentheses2(String s) {

        int left = 0, right = 0;

        // First, we find out the number of misplaced left and right parentheses.
        for (int i = 0; i < s.length(); i++) {

            // Simply record the left one.
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                // If we don't have a matching left, then this is a misplaced right, record it.
                right = left == 0 ? right + 1 : right;

                // Decrement count of left parentheses because we have found a right
                // which CAN be a matching one for a left.
                left = left > 0 ? left - 1 : left;
            }
        }

        this.recurse2(s, 0, 0, 0, left, right, new StringBuilder());
        return new ArrayList<String>(this.validExpressions2);
    }



}
