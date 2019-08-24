package leetcode;

/**
 * @Author: Songxc
 * @Date: 20:09 2019/8/24
 * @Description: 搜索二维矩阵II
 *  编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 *     每行的元素从左到右升序排列。
 *     每列的元素从上到下升序排列。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 *
 * 思路：
 *  贪心算法
 *
 *  时间复杂度：O(n+m)。
 * 时间复杂度分析的关键是注意到在每次迭代（我们不返回 true）时，行或列都会精确地递减/递增一次。由于行只能减少 m 次，而列只能增加 n 次，因此在导致 while 循环终止之前，循环不能运行超过 n+m 次。因为所有其他的工作都是常数，所以总的时间复杂度在矩阵维数之和中是线性的。
 * 空间复杂度：O(1)，因为这种方法只处理几个指针，所以它的内存占用是恒定的。
 *
 */
public class T240_SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }
}
