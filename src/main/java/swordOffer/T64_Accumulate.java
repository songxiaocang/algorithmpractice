package swordOffer;

/**
 * @Author: Songxc
 * @Date: 10:38 2019/6/30
 * @Description:  求1+2+...+n，要求不能使用乘除法，for，while，if，else，switch，case等关键词及条件判断语句？：。
 *  思路：
 *   构造一个特殊的循环表达式
 */
public class T64_Accumulate {
    public static int accumulate(int n){
        int sum = 0;
        boolean b = (n>0)&&((sum=n+accumulate(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(accumulate(10));
    }
}
