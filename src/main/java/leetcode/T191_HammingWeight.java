package leetcode;

/**
 * @Author: Songxc
 * @Date: 22:34 2019/9/4
 * @Description: 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 *
 * 思路：
 * 1） 循环和位移动：与 1 &
 * 2) 位操作：与 n-1 &
 * 时间复杂度、空间复杂度均为0（1）
 */
public class T191_HammingWeight {
    //位操作（推荐）
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= n - 1;
        }
        return sum;
    }

    //循环+位移动
    public int hammingWeight2(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

}
