package swordOffer;

/**
 * @Author: Songxc
 * @Date: 23:23 2019/6/9
 * @Description:  把数字翻译成字符串
 *  思路：
 *   找出递归表达式: f(r-2) = f(f-1) + g(r-2,r-1) * f(r)  表示从第r-2个数字到结尾的这一串数字能组合成的字符串个数。
 *   g(r-2, r-1) 表示index 为 r-2和r-1下标的组成数字是否在 0 - 25 之中，在其中为1，否则为0。
 */
public class T46_TranslateNumberToString {
    public static int translateNumberToString(int num){
        if (num < 0 ){
            return -1;
        }
        if (num < 9){
            return 1;
        }
        return translate(Integer.toString(num));
    }

    public static int translate(String str){
        int f1=0,f2=1,g=0;
        for (int i=str.length()-2; i>=0; i--){
            if (Integer.parseInt(str.charAt(i)+""+str.charAt(i+1)) <= 25){
                g = 1;
            }else{
                g = 0;
            }
            int temp = f2;
            f2 = f2 + g*f1;
            f1 = temp;
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println(translateNumberToString(-10));
        System.out.println(translateNumberToString(1234));
        System.out.println(translateNumberToString(12258));
    }
}

