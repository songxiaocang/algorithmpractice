package swordOffer;

/**
 * @Author: Songxc
 * @Date: 0:22 2019/5/5
 * @Description: 打印n位长度的整数
 *  思路：
 *   使用字符串模拟加法
 *   注意：加一判断（做到0(1)复杂度） 打印设置
 */
public class T17_Print1ToMaxOfNDigits {
    public static void print1ToMaxOfNDigits(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append('0');
        }
        while(increment(sb)){
            print(sb);
        }
    }

    public static boolean increment(StringBuilder sb){
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)<'9' && sb.charAt(i)>='0'){
                sb.setCharAt(i,(char)(sb.charAt(i)+1));
                return true;
            }else if(sb.charAt(i) == '9'){
                sb.setCharAt(i,'0');
            }else{
                return false;
            }
        }
        return false;
    }


    public static void print(StringBuilder sb){
        boolean flag = false;
        for(int i=0;i<sb.length();i++){
            if(flag){
                System.out.print(sb.charAt(i));
            }else if(sb.charAt(i)!='0'){
                flag = true;
                System.out.print(sb.charAt(i));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }

}

