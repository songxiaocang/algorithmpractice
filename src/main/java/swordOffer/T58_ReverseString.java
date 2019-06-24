package swordOffer;

/**
 * @Author: Songxc
 * @Date: 0:47 2019/6/25
 * @Description:  字符串翻转
 *  思路：
 *   先翻转整个字符串，再反转内部每个字符串
 */
public class T58_ReverseString {
    public static String reverseString(String str){
        if (str == null){
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        reverseString(sb, 0, str.length()-1);
        int start = 0, end= sb.indexOf(" ");
        while(start<sb.length() && end!=-1){
            reverseString(sb, start,end-1);
            start = end+1;
            end = sb.indexOf(" ",start);
        }
        if (start<sb.length()){
            reverseString(sb, start, sb.length()-1);
        }
        return sb.toString();
    }

    public static void reverseString(StringBuilder sb, int begin, int end){
        for(int i=begin;i<=(begin+end)/2;i++){
            char temp = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(end-i+begin));
            sb.setCharAt(end-i+begin,temp);
        }
    }

    public static void main(String[] args) {
        String str = "I am a Student.";
        String newStr = reverseString(str);
        System.out.println(newStr);
    }
}
