package leetcode;

/**
 * @Author: Songxc
 * @Date: 22:47 2019/7/30
 * @Description: 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 *
 *
 * 解题思路：
 * 1） 回溯法    时间复杂度 0(2 ^n), 空间复杂度为0（n）
 * 从左到右不断回溯
 * 2）动态规划（自顶向下）  时间复杂度为0（n^2）, 空间复杂度为0（n）
 * 在回溯算法的基础上，使用记忆表保存每次回溯的结果
 * 3）动态规划（自下向上）  时间复杂度为0（n^2）, 空间复杂度为0（n）
 * 放弃使用记忆表，从右到左依次判断当前节点是否满足最佳节点（可以通过自身运动到最后节点），直到遍历最左节点，才满足跳跃规则
 * 4）贪心算法   时间复杂度为0（n），空间复杂度为0（1）
 * 从右到左使用一个变量单独记录是否满足最佳节点情况，直到最变量记录的索引到达最左节点，才满足跳跃规则。
 */
public class T55_CanJump {
    public boolean canJump(int[] nums) {
        //贪心算法
        if (nums == null || nums.length <= 0) {
            return false;
        }
        int lastLeftIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastLeftIndex) {
                lastLeftIndex = i;
            }
        }

        return lastLeftIndex == 0;
    }


    //回溯算法
    public boolean canJumpFromPosition2(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump2(int[] nums) {
        return canJumpFromPosition2(0, nums);
    }

    //动态规划（自顶向下）
    Index[] memo;

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump3(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }


    //动态规划（自下向上）
    public boolean canJump4(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }

    enum Index {
        GOOD, BAD, UNKNOWN;
    }


}
