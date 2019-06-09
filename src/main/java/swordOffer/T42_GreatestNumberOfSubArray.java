package swordOffer;

/**
 * @Author: Songxc
 * @Date: 15:51 2019/6/9
 * @Description:  连续子数组的最大和
 *  思路：
 *    可以使用动态规划使用，得出动态规划方程：
 *    dp[i] = data[i]  i<=0 || dp[i-1] < 0
 *          = dp[i-1] + data[i] i>1
 *     可以使用一个变成maxDp来保存到末尾元素data[i]所有子数组的最大值
 *     该方法时间复杂度为0(n)，空间复杂度为0(1)
 */
public class T42_GreatestNumberOfSubArray {
    public static Integer getGreatestNumberOfSubArray(int[] data){
        if (data == null || data.length == 0){
            return null;
        }
        int dp = data[0];
        int maxDp = dp;
        for(int i=1; i<data.length; i++){
            if (dp > 0){
                dp += data[i];
            }else{
                dp = data[i];
            }

            if (dp > maxDp){
                maxDp = dp;
            }
        }
        return maxDp;
    }

    public static void main(String[] args) {
        int[] data = {1,-2,3,10,-4,7,2,-5};
        System.out.println(getGreatestNumberOfSubArray(data));
    }
}
