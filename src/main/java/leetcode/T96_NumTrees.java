package leetcode;

/**
 * @Author: Songxc
 * @Date: 1:48 2019/8/6
 * @Description: 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * <p>
 * 思路：
 * 找出规律。
 * G(N) 表示长度为N的二叉树的个数
 * G(n)=∑F(i,n) = ∑G(i−1)⋅G(n−i)  (∑范围从1到N)
 * <p>
 * 时间复杂度 : 上述算法的主要计算开销在于包含 G[i] 的语句。因此，时间复杂度为这些语句的执行次数，也就是 ∑i = (n+2)(n-1)/2 (∑范围从2到N)​。因此，时间复杂度为 O(N^2)。
 * <p>
 * 空间复杂度 : 上述算法的空间复杂度主要是存储所有的中间结果，因此为 O(N)O(N)O(N)。
 */
public class T96_NumTrees {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}
