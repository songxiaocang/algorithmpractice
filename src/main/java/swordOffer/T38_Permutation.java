package swordOffer;

import java.util.*;

/**
 * @Author: Songxc
 * @Date: 16:37 2019/6/2
 * @Description: 字符串的排列
 *  思路：
 *   分为两步：第一步将第一个字符串依次与后面的数字交换，第二步排列后面的字符知道交换到末尾。
 *   可以使用递归实现。
 */
public class T38_Permutation {
    public static List<char[]> permutation(char[] str){
        if(str == null || str.length == 0){
            return null;
        }

        List<char[]> ret = new LinkedList<>();
        permutationCore(str, ret, 0);
        return ret;
    }

    public static void permutationCore(char[] str, List<char[]> ret, int bound){
        if(bound == str.length) {
            ret.add(Arrays.copyOf(str, str.length));
        }
        Set<Character> set = new HashSet<>();
        for(int i=bound; i<str.length; i++){
            if(set.add(str[i])){
                swap(str, bound, i);
                permutationCore(str, ret, bound+1);
                swap(str, bound, i);
            }
        }
    }

    public static void swap(char[] str, int i, int j){
       char temp = str[i];
       str[i] = str[j];
       str[j] = temp;
    }

    public static void main(String[] args) {
        char[] str = {'a','b','c'};
        for (char val : str){
            System.out.print(val);
        }
        System.out.println();
        List<char[]> ret = permutation(str);
        for (char[] val : ret){
            for (char val1 : val){
                System.out.print(val1);
            }
            System.out.print("\t");
        }
        System.out.println();
    }
}
