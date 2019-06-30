package swordOffer;


/**
 * @Author: Songxc
 * @Date: 14:38 2019/6/30
 * @Description: 字符串转换为整数
 *  思路：
 *   要注意各种边界条件和无效输入：
 *    如空串、有空格、带小数点、正负号等多种情况
 */
public class T67_StringToInt {
    public static int stringToInt(String str){
        if (str == null || str.length() == 0){
            throw new RuntimeException("字符串为null或者为空字符串");
        }
        String maxVal = String.valueOf(Integer.MIN_VALUE).substring(1);
        int flag = 0;
        StringBuilder sb = new StringBuilder(str.trim());
        if (sb.charAt(0) =='+'){
            flag = 1;
        }else if(sb.charAt(0) == '-'){
            flag = -1;
        }else if (sb.charAt(0) >='0' && sb.charAt(0) <='9'){
            flag = 2;
        }else{
            return 0;
        }
        int index =1;
        while(index<sb.length() && sb.charAt(index) >='0' && sb.charAt(index) <='9'){
            index++;
        }
        if ((flag == 1 || flag == -1) && index==1){
            throw new RuntimeException("无效字符");
        }

        if (flag==2){
            if (sb.substring(0,index).compareTo(maxVal)>=0){
                throw new RuntimeException("字符串上溢");
            }
            return Integer.parseInt(sb.substring(0,index));
        }

        if (flag==1 && sb.substring(1,index).compareTo(maxVal)>=0){
            throw new RuntimeException("字符串上溢");
        }
        if (flag==-1 && sb.substring(1,index).compareTo(maxVal)>0){
            throw new RuntimeException("字符串下溢");
        }
        if (flag==-1 && sb.substring(1,index).compareTo(maxVal)==0){
            return Integer.MIN_VALUE;
        }
        System.out.println(sb.substring(1,index));
        return flag*Integer.parseInt(sb.substring(1,index));

    }

    public static void main(String[] args) {
        try{
            System.out.println(stringToInt(" 100")); //100
            System.out.println(stringToInt("-100")); //-100
            System.out.println(stringToInt("0")); //0
            System.out.println(stringToInt("-0"));//0
            System.out.println(stringToInt("1.23"));  //1
            System.out.println(stringToInt("-1.23")); //-1
            System.out.println(stringToInt(".123"));  //0

            System.out.println(stringToInt("2147483647"));  //2147483647
            System.out.println(stringToInt("-2147483647")); //-2147483647
            System.out.println(stringToInt("2147483647"));  //2147483647
            System.out.println(stringToInt("2147483648"));  //上溢
            System.out.println(stringToInt("-2147483648")); //-2147483648
            System.out.println(stringToInt("-2147483649")); //下溢
            System.out.println(stringToInt(null)); //待转换字符串为null或空串
            System.out.println(stringToInt(""));   //待转换字符串为null或空串
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
