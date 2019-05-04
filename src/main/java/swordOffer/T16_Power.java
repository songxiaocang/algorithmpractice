package swordOffer;

/**
 * @Author: Songxc
 * @Date: 22:11 2019/5/4
 * @Description: 实现函数double power（double base，int exponent），求base的exponent次方。不能使用库函数，不需要考虑大数问题。
 *  思路：
 *  注意边界条件、无效输入。
 *  使用递归。
 *  公式：
 *  a^n = a^(n-1)/2 * a^(n-1)/2 * a  (n为奇数)
 *  a^n = a^n/2 * a^n/2   (n为偶数)
 */
public class T16_Power {
    public static boolean invalidInput = false;
    public static double power(double base, int exponent){
        if (exponent == 0){
            return 1;
        }else if(exponent < 0){
            if(equals(base, 0)){
                invalidInput = true;
                return 0;
            }else{
                return 1/powerCore(base, exponent);
            }
        }else{
            return powerCore(base, exponent);
        }
    }

    public static double powerCore(double base, int exponent){
        if (exponent == 0){
            return 1;
        }
        if((exponent&1) == 0){
            double temp = powerCore(base, exponent>>1);
            return temp*temp;
        }else{
            double temp = powerCore(base, exponent>>1);
            return base*temp*temp;
        }
    }

    public static boolean equals(double base,int target){
        return -0.0001<(base-target) && (base-target)<0.0001;
    }

    public static void main(String[] args) {
        System.out.println("2的3次方结果："+power(2,3)+" 是否出错："+invalidInput);
    }


}
