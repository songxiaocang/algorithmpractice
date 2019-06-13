package swordOffer;

/**
 * @Author: Songxc
 * @Date: 0:31 2019/6/14
 * @Description:  最长不含重复字符字符串
 *  思路：
 *   可以使用动态规划。
 *   dp[i]仅与dp[i-1]值有关。可以使用maxDp变量来记录当前最长不重复字符自字符串的长度。
 */
public class T48_LongestSubStringWithoutDup {
    public static int longestSubStringWithoutDup(String str){
        if (str == null){
            return -1;
        }
        int[] dp = new int[str.length()];
        dp[0] = 1;
        int maxDp = 1;
        for (int index=1; index<str.length(); index++){
            int i = index -1;
            while(i>=index - dp[index-1]){
                if (str.charAt(i) == str.charAt(index)){
                    break;
                }
                i--;
            }
            dp[index] = index -i;
            if(dp[index] > maxDp){
                maxDp = dp[index];
            }
        }

        return maxDp;

    }

    public static void main(String[] args) {
        String str = "arabcacfr";
        System.out.println(longestSubStringWithoutDup(str));
    }
}
