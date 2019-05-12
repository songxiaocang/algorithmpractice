package swordOffer;

/**
 * @Author: Songxc
 * @Date: 14:11 2019/5/12
 * @Description: 判断一个字符串是不是整数
 *  思路：
 *   该字符串需符合这样的公式：A[.[B]][e|EC]   (A、B、C为整数)，按照该模式依次匹配
 */
public class T20_IsNumeric {
    public static boolean isNumeric(String str){
        if(str == null || str.length() == 0){
            return false;
        }
        int index;
        if(str.charAt(0) != '.'){
             index = scanInteger(str,0);
             if (index == -1){
                 return false;
             }
             if (index == str.length()){
                 return true;
             }
             if(str.charAt(index)=='.'){
                 if(index==str.length()-1){
                     return true;
                 }
                 index = scanInteger(str,index+1);
                 if (index == -1) {
                     return false;
                 }
                 if (index==str.length()){
                     return true;
                 }
             }
            if(str.charAt(index)=='e'||str.charAt(index)=='E'){
                index = scanInteger(str, index+1);
                if (index==str.length()){
                    return true;
                }else{
                    return false;
                }
            }
             return false;
        }else{
           index = scanInteger(str, 1);
           if (index==-1){
               return false;
           }
           if (index==str.length()){
               return true;
           }
           if(str.charAt(index)=='e'||str.charAt(index)=='E'){
               index = scanInteger(str, index+1);
               if (index==str.length()){
                   return true;
               }
           }
           return false;
        }
    }

    public static int scanInteger(String str, int index){
        if(index >= str.length()){
            return -1;
        }

        if (str.charAt(index)=='+' || str.charAt(index)=='-'){
            return scanUnsignedInteger(str, index+1);
        }else{
            return scanUnsignedInteger(str, index);
        }
    }

    public static int scanUnsignedInteger(String str, int index){
        int origin = index;
        while(index<str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
            index++;
        }
        if (origin==index){
            return -1;
        }
        return index;
    }


    public static void main(String[] args){
        System.out.println(isNumeric("6.1e6"));
    }
}
