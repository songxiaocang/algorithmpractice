package leetcode;

/**
 * @Author: Songxc
 * @Date: 1:22 2019/7/16
 * @Description: 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 思路：
 * 1） 常规法
 * 2）厄拉多塞筛法
 */
public class T204_CountPrimes {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int res = 1;
        for (int i = 3; i < n; i++) {
            if (i % 2 == 0) continue;
            boolean flag = true;
            for (int j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }

    public int countPrimes2(int n) {
        boolean[] num = new boolean[n + 1];
        for (boolean val : num) {
            val = true;
        }
        int res = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (num[i]) {
                int k = 2;
                while (k * i < n) {
                    num[k * i] = false;
                    k++;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (num[i])
                res++;
        }
        return res;


    }
}
