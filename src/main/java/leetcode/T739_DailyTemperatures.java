package leetcode;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 23:59 2019/9/13
 * @Description:  每日温度
 *  根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 *
 * 思路：
 *  1） 逆序迭代遍历（跳跃对比）  时间复杂度为0（n）
 *  2） 逆序栈
 *   时间复杂度为0（n）
 *   注意这里虽然有两层循环，但仍然是 O(n) 的时间复杂度，因为每个元素只进栈一次并且也最多只会比较一次，但这种方法仍然需要使用 O(n) 的空间复杂度。
 *
 *
 */
public class T739_DailyTemperatures {
    //后向迭代遍历
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < length; j+= result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }

        return result;
    }

    //逆序栈
    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        // 单调栈 里面的数 非递增排序
        Stack<Integer> stack = new Stack();
        // 从后往前遍历
        for(int i = T.length-1; i >= 0; i--){
            // 当前元素比栈顶元素大 出栈 重新调整栈直至满足要求
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            // 栈为空 即后面没有比当前天温度高的
            // 不为空 栈顶元素对应的下标减去当前下标即为经过几天后温度比当前天温度高
            res[i] = stack.isEmpty()? 0 :stack.peek()-i;
            // 当前元素进栈
            stack.push(i);
        }
        return res;
    }




}
