package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Songxc
 * @Date: 16:54 2019/8/25
 * @Description: 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 *
 * 思路：
 *  有三种解法： 排序， 集合， 双指针
 *  1）排序  时间复杂度为0(nlogn)， 空间复杂度为0（1）或者0（n）
 *  时间复杂度：O(nlgn)。排序调用在 Python 和 Java 中花费 O(nlgn)时间，因此它支配后续的线性扫描。
 * 空间复杂度：O(1) / O(n)，在这里，我们对 nums 进行排序，因此内存大小是恒定的。如果我们不能修改输入数组，那么我们必须为 nums 的副本分配线性空间，并对其进行排序。
 *
 *  2) 集合
 *  时间复杂度：O(n)。Python 和 Java 都依赖于底层的哈希表，所以插入和查找有固定的时间复杂度。因此，该算法是线性的，因为它由一个执行 N 次恒定工作的 for 循环组成。
 * 空间复杂度：O(n)，在最坏的情况下，重复元素出现两次，其中一次出现在数组索引 n−1 处。在这种情况下，set 将包含 n−1 不同的值，因此将占用 O(n) 空间。
 *
 * 3）快慢指针
 *  时间复杂度：O(n)
 *  空间复杂度：O(1)
 *
 */
public class T287_FindDuplicate {
    //双指针
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0], hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        int p1 = nums[0];
        int p2 = tortoise;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }

        return p2;
    }

    //排序
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }

    //集合set
    public int findDuplicate3(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }


}
