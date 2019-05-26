package swordOffer;

import java.util.Stack;
/**
 * @Author: Songxc
 * @Date: 18:26 2019/5/26
 * @Description: 栈的压入、弹出序列
 *  输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出序序列。假设压入栈的所有数字均不相等。例如，压入序列为(1,2,3,4,5)，序列(4,5,3,2,1)是它的弹出序列，而(4,3,5,1,2)不是。
 *
 *   思路：
 *    压栈，判断栈顶元素与弹出序列元素是否一致，不一致继续压栈，直到满足条件，然后弹栈，继续匹配下一个元素直到弹出序列末尾。如果不满足上述条件，就不是弹出序列。
 */
public class T31_StackPushPopOrder {
    public static boolean stackPushPop(int[] pushSeq, int[] popSeq){
        if(pushSeq == null || popSeq == null || pushSeq.length == 0 || popSeq.length == 0 || pushSeq.length != popSeq.length){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while(popIndex < popSeq.length){
            if(stack.isEmpty() || !stack.peek().equals(popSeq[popIndex])){
                if(pushIndex < pushSeq.length){
                    stack.push(pushSeq[pushIndex++]);
                }else{
                    return false;
                }
            }else{
                stack.pop();
                popIndex++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        int[] pop2 = {4,3,5,1,2};

        System.out.println(stackPushPop(push, pop1));
        System.out.println(stackPushPop(push, pop2));
    }
}
