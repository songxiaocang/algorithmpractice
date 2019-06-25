package swordOffer;

/**
 * @Author: Songxc
 * @Date: 23:14 2019/6/25
 * @Description:  左旋转字符串（翻转指定位数i）
 *  思路：
 *   先翻转0 ~ i-1位和 i ~ length-1位，最后反转整个字符串
 */
public class T58_2_ReverseString2 {
    public static String reverseString(String str, int i){
        if (str == null || str.length()<=0 || i<=0 || i>str.length()){
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        reverseString(sb, 0 ,i-1);
        reverseString(sb,i, str.length()-1);
        reverseString(sb,0,str.length()-1);
        return sb.toString();
    }

    public static void reverseString(StringBuilder sb, int begin, int end){
        for(int i=begin;i<=(begin+end)/2;i++){
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(end-i+begin));
            sb.setCharAt(end-i+begin,temp);
        }
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(reverseString(str, 2));
    }
}
