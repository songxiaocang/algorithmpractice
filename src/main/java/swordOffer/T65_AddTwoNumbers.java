package swordOffer;

/**
 * @Author: Songxc
 * @Date: 11:12 2019/6/30
 * @Description: 计算两数之和（不使用+ - * /运算）
 *  思路：
 *   使用异或 和 与操作进行循环实现
 */
public class T65_AddTwoNumbers {
    public static int addTwoNumbers(int a, int b){
        int sum = a^b;
        int carry = (a&b)<<1;
        while(carry!=0){
            int temp = sum;
            sum = sum^carry;
            carry=(carry&temp)<<1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(3,5));
    }
}
