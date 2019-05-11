package swordOffer;

/**
 * @Author: Songxc
 * @Date: 22:13 2019/5/11
 * @Description: 正则表达式匹配问题
 *  思路：
 *   分情况处理：
 *   1）模式串第二个字符是*号  直接将模式串指针右移两位
 *   2）模式串第二个字符不是*号 逐个匹配
 */
public class T19_RegularExpressionMatch {
    public static boolean match(String str, String pattern){
        if(str == null || pattern == null){
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }

    public static boolean matchCore(String str, int strIndex, String pattern, int patternIndex){
        //匹配串和模式串已经匹配到尾部
        if(strIndex == str.length() && patternIndex == pattern.length()){
            return true;
        }else if(strIndex != str.length() && patternIndex == pattern.length()){
            return false;
        }else if(strIndex == str.length() && patternIndex != pattern.length()){
            if(patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex+1) == '*'){
                return matchCore(str, strIndex, pattern, patternIndex+2);
            }else{
                return false;
            }
        }

        //如果只剩下最后一个字符或者模式串第二个字符不是*
        if(patternIndex == pattern.length() - 1 || pattern.charAt(patternIndex+1) != '*'){
            if (pattern.charAt(patternIndex) == '.' || pattern.charAt(patternIndex) == str.charAt(strIndex)){
                return matchCore(str, strIndex+1, pattern, patternIndex+1);
            }else{
                return false;
            }
        }else{ //模式串第二个字串是*
            if (pattern.charAt(patternIndex) == '.' || pattern.charAt(patternIndex) == str.charAt(strIndex)){
                return matchCore(str, strIndex, pattern, patternIndex+2)||
                        matchCore(str, strIndex+1, pattern, patternIndex)||
                        matchCore(str, strIndex+1, pattern, patternIndex+2);
            }else{
                return matchCore(str, strIndex, pattern, patternIndex+2);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(match("aaa","a*a")); //true
        System.out.println(match("aaaa","a.a")); //false
        System.out.println(match("aaa","ab*ac*a")); //true
    }
}
