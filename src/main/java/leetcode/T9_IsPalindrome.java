package leetcode;

/**
 * @Author: Songxc
 * @Date: 9:01 2019/8/24
 * @Description: 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * <p>
 * 思路：
 * 有三种解法：字符串反转对比， 前后对比， 反转右半部分左右对比
 * 1）普通解法：字符串反转对比
 * 先将 整数转为字符串 ，然后将字符串分割为数组，只需要循环数组的一半长度进行判断对应元素是否相等即可。
 * <p>
 * 2） 前后对比 （取整和取余操作）
 * 示例：
 * 通过计算 1221 / 1000， 得首位1
 * 通过计算 1221 % 10， 可得末位 1
 * 进行比较
 * 再将 22 取出来继续比较
 * <p>
 * 3）反转右半部分左右对比 (进阶操作)
 * 取出后半段数字进行翻转
 * 这里需要注意的一个点就是由于回文数的位数可奇可偶，所以当它的长度是偶数时，它对折过来应该是相等的；当它的长度是奇数时，那么它对折过来后，有一个的长度需要去掉一位数（除以 10 并取整）。
 */
public class T9_IsPalindrome {
    //反转右半部分左右对比
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertNumber = 0;
        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertNumber || x == revertNumber / 10;
    }


    //字符串反转
    public boolean isPalindrome2(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    //前后对比
    public boolean isPalindrome3(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

}
