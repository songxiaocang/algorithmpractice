package swordOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Songxc
 * @Date: 14:39 2019/5/2
 * @Description: 用两个队列实现一个栈
 * 思路：
 *  queue1负责插入数据，当要移除数据时，从queue1移动元素到queue2直到queue1中只剩下一个元素，然后弹出queue1中的元素即可。
 *  当再要移除元素时，从queue2中移除元素插入到queue1中，直到queue2中只剩下一个元素，然后弹出queue2中的元素即可。
 */
public class T09_2_MyStack<T> {
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public void push(T data){
        queue1.add(data);
    }

    public T pop(){
        if (!queue1.isEmpty()){
            while(queue1.size() > 1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }else if(!queue2.isEmpty()){
            while(queue2.size()>1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }

        return null;
    }


    public static void main(String[] args){
        T09_2_MyStack myStack = new T09_2_MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
