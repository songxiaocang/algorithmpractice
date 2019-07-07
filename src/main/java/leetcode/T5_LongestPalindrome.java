package leetcode;

/**
 * @Author: Songxc
 * @Date: 20:20 2019/7/7
 * @Description: 最长回文子串
 *  思路：
 *   有多种解法：
 *    暴力破解法 （0(n3)）    中心扩散法（0(n2)）
 *    动态规划法 (0(n2))   manacher算法 （0(n)）
 */
public class T5_LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s==null && s.length()<=1){
            return s;
        }

        int maxLen = 1;
        String palindromeStr = s.substring(0,1);
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int r=1;r<len;r++){
            for(int l=0;l<len;l++){
                if(s.charAt(l) == s.charAt(r) && (r-l<=2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                }
                if(r-l+1 > maxLen){
                    maxLen = r-l+1;
                    palindromeStr = s.substring(l,r+1);
                }
            }
        }

        return palindromeStr;
    }

    public static void main(String[] args) {
        String str = " ";
        System.out.println(longestPalindrome(str));
    }
}
