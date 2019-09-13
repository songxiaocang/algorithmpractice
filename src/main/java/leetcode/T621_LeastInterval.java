package leetcode;

import java.util.Arrays;

/**
 * @Author: Songxc
 * @Date: 20:18 2019/9/13
 * @Description: 任务调度器
 *  给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * 示例 1：
 *
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 *
 * 思路：
 *   贪心算法
 *
 *   核心公式：  总执行时间 = （单个任务出现最多频率  -1） *（等待时间n + 1） + 出现最多频率任务的个数
 */
public class T621_LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;
        int[] number = new int[26];
        for (int i = 0; i<tasks.length; i++){
            number[tasks[i]-'A']++;
        }
        Arrays.sort(number);
        //取出最大值，和最大值个数
        int max = number[number.length-1];
        int i=number.length-1; int max_len =0;
        while(number[i--]==max) max_len++;
        //A->B->X ->A->B->X ->A->B
        //A的个数-1*每一组的数（n+1）+最大值相同的个数
        return Math.max((max-1)*(n+1)+max_len,tasks.length);
    }

}
