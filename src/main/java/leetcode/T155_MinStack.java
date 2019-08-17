package leetcode;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 22:43 2019/8/17
 * @Description: 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *     push(x) -- 将元素 x 推入栈中。
 *     pop() -- 删除栈顶的元素。
 *     top() -- 获取栈顶元素。
 *     getMin() -- 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 *
 *  思路：
 *   使用数据栈+ 辅助栈（保存最小值）
 *
 *   时间：
 *   时间复杂度0（1），空间复杂度0（n）
 */
public class T155_MinStack {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public T155_MinStack() {

    }

    public void push(int x) {
        stackData.push(x);
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else {
            int value = stackMin.peek();
            if (value < x) {
                stackMin.push(value);
            } else {
                stackMin.push(x);
            }
        }
    }

    public void pop() {
        if (stackData.isEmpty()) {
            return;
        }
        stackMin.pop();
        stackData.pop();

    }

    public int top() {
        if (stackData.isEmpty()) {
            return -1;
        }
        return stackData.peek();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            return -1;
        }
        return stackMin.peek();

    }
}
