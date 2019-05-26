package swordOffer;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 16:53 2019/5/26
 * @Description: 包含min函数的栈，min 、push、pop方法时间复杂度为0(1)
 * 思路：
 *  使用两个栈实现：数据栈和辅助栈（保存最小数值）
 */
public class T30_StackWithMin {

    static class StackWithMin<T extends Comparable>{
        private Stack<T> stackData = new Stack<>();
        private Stack<T> stackMin = new Stack<>();
        
        
        public StackWithMin(){}

        public void push(T data){
            stackData.push(data);
            if(stackMin.isEmpty()){
                stackMin.push(data);
            }else{
                T val = stackMin.peek();
                if(val.compareTo(data)<0){
                    stackMin.push(val);
                }else{
                    stackMin.push(data);
                }
            }
        }

        public T pop(){
            if(stackData.isEmpty()){
                return null;
            }
            stackMin.pop();
            return stackData.pop();
        }

        public T min(){
            if(stackMin.isEmpty()){
                return null;
            }
            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<Integer>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
    }
}
