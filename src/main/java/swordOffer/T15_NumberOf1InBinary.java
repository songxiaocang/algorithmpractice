package swordOffer;

/**
 * @Author: Songxc
 * @Date: 18:27 2019/5/4
 * @Description: 二进制中1的个数
 *  思路：
 *  1）原数右移
 *  2）定义一个标记，左移
 *  3）利用定理：一个数与上它本身减去1的数，会将它最右边的1变成0
 */
public class T15_NumberOf1InBinary {
    public static int solution1(int n){
        int count = 0;
        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static int solution2(int n){
        int count = 0;
        int flag = 1;
        while(flag!=0){
            if((n&flag)!=0){
                count++;
            }

            flag <<= 1;

        }

        return count;
    }

    public static int solution3(int n){
        int count = 0;
        while(n>0){
            count++;
            n = n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution1(3));
        System.out.println(solution2(3));
        System.out.println(solution3(3));
    }
}
