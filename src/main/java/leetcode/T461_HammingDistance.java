package leetcode;

/**
 * @Author: Songxc
 * @Date: 0:16 2019/9/12
 * @Description:  汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 *
 * 思路：
 *  位运算 + 右移
 */
public class T461_HammingDistance {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        while(x != 0 || y != 0){
            if((x & 1) != (y & 1)){
                ans++;
            }
            x=x>>1;
            y=y>>1;
        }

        return ans;
    }
}
