package leetcode;

/**
 * @Author: Songxc
 * @Date: 23:10 2019/9/4
 * @Description: 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 *
 *  思路：
 *  1） 动态规划+最高有效位
 *      (0)=(0)2​
 *      (1)=(1)2
 *      (2)=(10)2
 *      (3)=(11)2
 *      可以看出， 2 和 3 的二进制形式可以通过给 0 和 1 的二进制形式在前面加上 1 来得到。因此，它们的 pop count 只相差 1。
 *      有以下的状态转移函数：
 *      P(x+b)=P(x)+1,b=2^m>x
 *
 *  2）动态规划+最低有效位
 *   x=(1001011101)2​=(605)10​
 *   x′=(100101110)2=(302)10x' = (100101110)_2 = (302)_{10} x′=(100101110)2​=(302)10​
 *  可以发现 x′x'x′ 与 xxx 只有一位不同，这是因为x′x'x′ 可以看做 xxx 移除最低有效位的结果。
 *  这样，我们就有了下面的状态转移函数：
 *  P(x)=P(x/2)+(x mod  2)

 *  3） 动态规划+最后设置位
 *  最后设置位是从右到左第一个为1的位。使用 x &= x - 1 将该位设置为0，就可以得到以下状态转移函数：
 *  P(x)=P(x&(x−1))+1;
 *
 *  时间复杂度、空间复杂度均为0（n）
 *
 */
public class T338_CountBits {
    //动态规划+最低有效位
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        for(int i=1; i<=num; i++){
            ans[i] = ans[i>>1] + (i & 1);
        }
        return ans;
    }

    //动态规划+最后设置位
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }

    //动态规划+最高有效位
    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }

}
