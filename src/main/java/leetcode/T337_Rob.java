package leetcode;

import util.TreeNode;

/**
 * @Author: Songxc
 * @Date: 0:05 2019/9/4
 * @Description: 打家劫舍3
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 *
 * 思路：
 *  动态规划
 *   1） 递归DFS
 *   2) 递归数组/队列
 */
public class T337_Rob {
    public static int rob(TreeNode<Integer> root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }

        return Math.max(robDFS(root, true), robDFS(root, false));
    }

    public static int robDFS(TreeNode<Integer> node, Boolean visit){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return visit ? node.val : 0;
        }

        int left = 0, right = 0;
        if(visit){
            if(node.left != null){
                left = robDFS(node.left, !visit);
            }
            if(node.right != null){
                right = robDFS(node.right, !visit);
            }

            return node.val + left + right;
        }else{
            if(node.left != null){
                left = Math.max(robDFS(node.left, !visit), robDFS(node.left, visit));
            }
            if(node.right != null){
                right = Math.max(robDFS(node.right, !visit), robDFS(node.right, visit));
            }
            return left + right;
        }
    }


    //递归队列
    //dp[0]表示不选根节点的的max，dp[1]表示选了根节点的max
    public int robIII2(TreeNode<Integer> root) {
        int[] dp = robHelper2(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] robHelper2(TreeNode<Integer> root) {
        int[] dp = new int[2];
        if (root == null) return dp;
        int[] left = robHelper2(root.left);
        int[] right = robHelper2(root.right);
        //dp[0]=max{左子树选与不选根节点的最大值+右子树选与不选根节点的最大值}
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //dp[1]=左子树不选根节点的左孩子节点（因为选了根节点root,root.left不能再选了）+
        //右子树不选根节点的右孩子节点（因为选了根节点root,root.right不能再选了）+root.val
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }



    public static void main(String[] args) {
        /**
         *         4
         *        /\
         *       1
         *      /
         *     2
         *    /
         *   3
         */
        TreeNode<Integer> root = new TreeNode<>(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        System.out.println(rob(root));
    }
}
