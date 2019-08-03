package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Songxc
 * @Date: 0:22 2019/8/2
 * @Description: 合并区间
 *  给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 *
 *  思路：
 *  重点：原数组经过排序后，可以合并的区间一定是连续的。
 *  先根据一维数组首元素进行升序排序，然后依次比较原数组前一一维数组与后一一维数组之间是否有交叉，无交叉，追加到新数组后面，有交叉，直接覆盖，
 *  如此，直到遍历完原数组。
 *
 *  时间复杂度 0（nlogn）  主要在比较器排序时间复杂度，其余都是线性扫描
 *
 */
public class T56_Merge {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0] ? -1 : (o1[0] == o2[0]) ? 0 : 1;
            }
        });

        int[][] merge = new int[intervals.length][2];


        merge[0] = intervals[0];
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (merge[j][1] < intervals[i][0]) {
                j++;
                merge[j] = intervals[i];
            } else if (merge[j][1] < intervals[i][1]) {
                merge[j][1] = intervals[i][1];
            }
        }
        int[][] newMerge = new int[j + 1][2];
        for (int k = 0; k <= j; k++) {
            newMerge[k] = merge[k];
        }
        return newMerge;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 7}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0] + " " + merge[i][1]);
        }
    }
}
