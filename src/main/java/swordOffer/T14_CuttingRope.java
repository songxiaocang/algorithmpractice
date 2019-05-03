package swordOffer;

/**
 * @Author: Songxc
 * @Date: 1:08 2019/5/4
 * @Description:  动态规划 ：割绳子
 *  给你一根长度为n的绳子，请把绳子剪成m段，记每段绳子长度为k[0],k[1]...k[m-1],求k[0]k[1]...k[m-1]的最大值。已知绳子长度n为整数，m>1(至少要剪一刀，不能不剪)，k[0],k[1]...k[m-1]均要求为整数。
 * 例如，绳子长度为8时，把它剪成3-3-2，得到最大乘积18；绳子长度为3时，把它剪成2-1，得到最大乘积2。
 *
 * 思路：
 *  找出动态转移方程：f(n) = max(f(i) * f(n-i))
 */
public class T14_CuttingRope {
    /**
     * 解法1：动态规划：时间复杂度：O(N2)
     * @param length
     * @return
     */
    public static int cuttingRope(int length){
        if (length < 2){
            return 0;
        }else if(length == 2){
            return 1;
        }else if(length == 3){
            return 2;
        }

        int[] dp = new int[length+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<=length;i++){
            int max = 0;
            for(int j=1;j<=i/2;j++){
                int temp = dp[j]*dp[i-j];
                if(temp>max){
                    max = temp;
                }
            }

            dp[i] = max;
        }

        return dp[length];
    }


    /**
     * 贪婪算法：时间复杂度0(1)
     * 切成尽可能多的3分段，然后剩余为4的时候，划分为2分段，该方法可降低时间复杂度，但是需要数学公式验证
     * @param length
     * @return
     */
    public static int cuttingRope2(int length){
        if (length < 2){
            return 0;
        }else if(length == 2){
            return 1;
        }else if(length == 3){
            return 2;
        }

        int term3 = length / 3;
        if(length - term3 * 3 == 1){
            --term3;
        }
        int term2 = (length - term3 * 3)/2;
        return (int) (Math.pow(3,term3) * Math.pow(2,term2));
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(6));
        System.out.println(cuttingRope2(6));
    }
}
