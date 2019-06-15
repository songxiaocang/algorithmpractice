package swordOffer;

/**
 * @Author: Songxc
 * @Date: 14:31 2019/6/15
 * @Description: 丑数
 *  思路：
 *   有两种解决办法：暴力破解法和数组法
 *   前者消耗较大的时间复杂度，后者以空间换时间
 */
public class T49_GetUglyNumber {
    //暴力破解法
    public static int getUglyNumber(int num) {
        if (num < 0) {
            return -1;
        }
        int number = 1;
        int uglyNum = 0;
        while(uglyNum < num){
            if (isUgly(number)){
                uglyNum++;
            }
            number++;
        }
        return number-1;
    }

    //使用有序数组保存已经计算出的丑数（空间换时间）
    public static boolean isUgly(int number){
        while(number%2==0){
            number/=2;
        }
        while(number%3==0){
            number/=3;
        }
        while(number%5==0){
            number/=5;
        }
        return number==1;
    }


    public static int getUglyNumber2(int num){
        if (num < 0){
            return -1;
        }
        int[] dp = new int[num];
        dp[0] = 1;
        int index = 1;
        int index2 = 0,index3 = 0,index5 =0;
        while(index < num){
            dp[index] = min(dp[index2]*2,dp[index3]*3,dp[index5]*5);
            if (dp[index2]*2 == dp[index]){
                index2++;
            }
            if (dp[index3]*3 == dp[index]){
                index3++;
            }
            if (dp[index5]*5 == dp[index]){
                index5++;
            }
            index++;
        }

        return dp[num-1];
    }

    public static int min(int num1, int num2, int num3){
        int temp = num1<num2?num1:num2;
        return temp<num3?temp:num3;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(10));
        System.out.println(getUglyNumber2(10));
    }
}
