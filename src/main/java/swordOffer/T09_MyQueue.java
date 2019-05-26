package swordOffer;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 14:14 2019/5/2
 * @Description: 用双栈实现一个队列
 *  思路：
 *  （1）对于插入操作，栈与队列都是从队尾进行，因此一行代码就可以完成offer()
 * （2）对于弹出操作，队列先进先出从队头开始，而栈后进先出从队尾开始，要想取到队头元素，就得需要第二个栈stack2的协助：弹出时将stack1的元素依次取出放到stack2中，此时stack2进行弹出的顺序就是整个队列的弹出顺序。而如果需要插入，放到stack1中即可。
 * 总结下，stack1负责插入，stack2负责弹出，如果stack2为空了，将stack1的元素依次弹出并存放到stack2中，之后对stack2进行弹出操作。
 *
 */
public class T09_MyQueue<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void offer(T data){
        stack1.push(data);
    }

    public T poll(){
        if (!stack2.isEmpty()){
            return stack2.pop();
        }else if(!stack1.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

        return null;
    }

    public static void main(String[] args){
        T09_MyQueue<Object> myQueue = new T09_MyQueue<>();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);

        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

    }
}
