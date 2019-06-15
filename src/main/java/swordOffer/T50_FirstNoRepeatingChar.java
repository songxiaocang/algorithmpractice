package swordOffer;

/**
 * @Author: Songxc
 * @Date: 19:31 2019/6/15
 * @Description:  第一个只出现一次的字符
 *  思路：
 *   有两种解法：暴力破解法（时间复杂度为0(n2)），和数组法（利用数组保存出现次数，时间复杂度为0(n)）
 */
public class T50_FirstNoRepeatingChar {
    //暴力破解法
    public static char firstNoRepeatingChar1(String str){
        if (str == null){
            return '\77';
        }
        for (int i=0;i<str.length();i++){
            for (int j=0;j<str.length();j++){
                if (i==j){
                    continue;
                }
                if (j==str.length()-1){
                    return str.charAt(i);
                }
                if (str.charAt(i) == str.charAt(j)){
                    break;
                }

            }
        }
        return '\77';
    }

    //哈希表（数组）
    public static char firstNoRepeatingChar2(String str){
        if (str == null){
            return '\77';
        }
        int[] times = new int[256];

        for (int i=0;i<str.length();i++){
            times[str.charAt(i)]++;
        }
        for (int i=0;i<str.length();i++){
            if (times[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }
        return '\77';
    }

    public static void main(String[] args) {
        System.out.println(firstNoRepeatingChar1("abaccdeff"));
        System.out.println(firstNoRepeatingChar2("abaccdeff"));
    }

}
