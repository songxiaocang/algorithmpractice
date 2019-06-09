package swordOffer;

/**
 * @Author: Songxc
 * @Date: 17:52 2019/6/9
 * @Description:  1~n整数中1出现的次数
 *  思路；
 *  有两种方法：暴力破解法（时间复杂度为0(nlogn)）,递归法（时间复杂度为0(logn)）
 */
public class T43_NumberOf1Between1AndN {
    public static int numberOf1Between1AndN(int n){
        if (n == 0){
            return 0;
        }
        if (n>=1 && n<10){
            return 1;
        }
        int count = 0;
        for (int i=0;i<=n;i++){
            for (int j=i;j>0;j=j/10){
                if (j%10 == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public static int numberOf1Between1AndN2(int n){
        if (n == 0){
            return 0;
        }
        if (n>=1 && n<10){
            return 1;
        }
        String str = String.valueOf(n);
        char prefixChar = str.charAt(0);
        String suffixStr = str.substring(1);
        int count1 = 0;
        if (prefixChar > '1'){
            count1 = power10(str.length() - 1);
        }else{
            count1 = Integer.parseInt(suffixStr) + 1;
        }
        int count2 = ( prefixChar - '0')*power10(suffixStr.length()-1)*suffixStr.length();
        return count1+count2+numberOf1Between1AndN2(Integer.parseInt(suffixStr));
    }

    public static int power10(int n){
        int count = 1;
        for(int i=1;i<=n;i++){
            count *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN(121));
        System.out.println(numberOf1Between1AndN2(121));
        System.out.println(numberOf1Between1AndN(789));
        System.out.println(numberOf1Between1AndN2(789));
    }
}
