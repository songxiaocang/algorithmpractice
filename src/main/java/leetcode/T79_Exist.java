package leetcode;

/**
 * @Author: Songxc
 * @Date: 20:19 2019/8/4
 * @Description: 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * <p>
 * 思路：
 * dfs和 回溯法
 */
public class T79_Exist {
    private int m;
    private int n;
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private boolean[][] marked;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length <= 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;
        marked = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;

    }

    public boolean dfs(char[][] board, int i, int j, int start, String word) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }

        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int nextX = i + direction[k][0];
                int nextY = j + direction[k][1];
                if (inArea(nextX, nextY) && !marked[nextX][nextY]) {
                    if (dfs(board, nextX, nextY, start + 1, word)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }

        return false;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
