package swordOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Songxc
 * @Date: 17:34 2019/6/29
 * @Description: 滑动窗口的最大值
 *  思路：
 *   使用双端队列实现，保证时间复杂度为0(n)。
 *   暴力破解法和双栈实现法时间复杂度为0(nk).
 */
public class T59_MaxInSlidingWindow {
    public static int[] maxInSlidingWindow(int[] data, int size) {
        if (data == null || data.length == 0) {
            return null;
        }
        if (data.length < size) {
            int min = data[0];
            for (int i = 1; i < data.length; i++) {
                if (data[i] > min) {
                    min = data[i];
                }
            }
            int[] result = new int[1];
            result[0] = min;
            return result;
        }

        int[] result = new int[data.length - size + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && data[i] >= data[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (int i = size - 1; i < data.length; i++) {
            while (!deque.isEmpty() && (i - deque.getFirst() + 1) > size) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && data[i] >= data[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            result[i - (size - 1)] = data[deque.getFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] data = {2, 3, 4, 2, 6, 2, 5, 1};
        int[] result = maxInSlidingWindow(data, 3);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
