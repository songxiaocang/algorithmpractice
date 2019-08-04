package leetcode;

/**
 * @Author: Songxc
 * @Date: 11:14 2019/8/4
 * @Description: 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * <p>
 * <p>
 * 思路：
 * 三指针法  时间复杂度为0(n)  空间复杂度为0（1）
 * 首先p0 p2分别指向最左最右边界，cur指针为当前index（从最左位置开始），如果num[cur] ==0 ，则将num[cur]和num[p0]交换，
 * 并向右移动p0 cur坐标；如果num[cur]==2则将num[cur]和num[p2]交换，并向左移动p2坐标；否则只向右移动cur坐标；如此直到
 * 循环遍历原数组结束。
 */
public class T75_SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int p0 = 0, p2 = nums.length - 1, cur = 0;
        int temp;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                temp = nums[p0];
                nums[p0++] = nums[cur];
                nums[cur++] = temp;
            } else if (nums[cur] == 2) {
                temp = nums[p2];
                nums[p2--] = nums[cur];
                nums[cur] = temp;
            } else {
                cur++;
            }
        }
    }
}
