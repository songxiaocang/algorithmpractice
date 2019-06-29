package swordOffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Songxc
 * @Date: 18:39 2019/6/29
 * @Description: 队列的最大值
 *  思路：
 *   使用两个双端队列实现（数据队列和最大值队列），保证push pop时间复杂度为0(1)。
 *   参考之前题的思路：滑动窗口最大值
 */
public class T59_2_QueueWithMax {
    public static class QueueWithMax<T extends Comparable> {
        private Deque<InternalData<T>> dequeData;
        private Deque<InternalData<T>> dequeMax;
        private int curIndex;

        public QueueWithMax() {
            this.dequeData = new ArrayDeque<>();
            this.dequeMax = new ArrayDeque<>();
            this.curIndex = 0;
        }

        public T max() {
            if (dequeMax.isEmpty()) {
                return null;
            }
            return dequeMax.peek().val;
        }

        public void pushBack(T data) {
            while (!dequeMax.isEmpty() && data.compareTo(dequeMax.getLast().val) >= 0) {
                dequeMax.removeLast();
            }
            InternalData<T> internalData = new InternalData<>(data, curIndex);
            dequeMax.addLast(internalData);
            dequeData.addLast(internalData);
            curIndex++;
        }

        public T popFront() {
            if (dequeData.isEmpty()) {
                return null;
            }
            InternalData<T> internalData = dequeData.removeFirst();
            if (internalData.val.compareTo(dequeMax.getFirst().val) == 0) {
                dequeMax.removeFirst();
            }
            return internalData.val;
        }
    }

    public static class InternalData<E extends Comparable> {
        private E val;
        private int index;

        public InternalData(E val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        QueueWithMax<Integer> queueWithMax = new QueueWithMax<>();
        queueWithMax.pushBack(3);
        System.out.println(queueWithMax.max());
        queueWithMax.pushBack(5);
        System.out.println(queueWithMax.max());
        queueWithMax.pushBack(1);
        System.out.println(queueWithMax.max());

        queueWithMax.popFront();
        System.out.println(queueWithMax.max());
        queueWithMax.popFront();
        System.out.println(queueWithMax.max());
        queueWithMax.popFront();
        System.out.println(queueWithMax.max());
    }
}
