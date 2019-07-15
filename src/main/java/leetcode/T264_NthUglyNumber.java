package leetcode;

/**
 * @Author: Songxc
 * @Date: 22:47 2019/7/15
 * @Description: 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 思路：
 *  丑数可以看作基础数 1乘 2、3、5得到，使用三个指针分别指向基础数字，向后乘2或3或5，比较大小保存在数组中，
 *  直到得到第n个丑数 （空间换时间）
 */
public class T264_NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] num = new int[n];
        num[0] = 1;
        int uglyIndex =0,multiply2=0,multiply3=0,multiply5=0;
        while(uglyIndex+1 < n){
            num[++uglyIndex] = min(num[multiply2]*2,num[multiply3]*3,num[multiply5]*5);
            if(num[multiply2]*2 == num[uglyIndex]){
                multiply2++;
            }
            if(num[multiply3]*3 == num[uglyIndex]){
                multiply3++;
            }
            if(num[multiply5]*5 == num[uglyIndex]){
                multiply5++;
            }
        }
        return num[n-1];
    }

    public int min(int a, int b, int c){
        int temp = a < b ? a : b;
        return temp < c ? temp : c;
    }
}
