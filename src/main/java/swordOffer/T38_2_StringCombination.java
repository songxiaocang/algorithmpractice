package swordOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Songxc
 * @Date: 21:23 2019/6/2
 * @Description:  字符串的组合
 *   输入一个字符串，打印出该字符串中字符的所有组合。如输入abc，则打印a，b，c，ab，ac，bc，abc。
 *   思路：
 *   区别于排列，每个元素有选中和被选中两种状态（排除为空的情况），利用递归实现。
 */
public class T38_2_StringCombination {
    public static List<char[]> combination(char[] str){
        if(str == null || str.length == 0){
            return null;
        }
        Arrays.sort(str);
        List<char[]> ret = new LinkedList<>();
        combinationCore(str, ret, new StringBuilder(), 0);
        return ret;
    }

    public static void combinationCore(char[] str, List<char[]> ret, StringBuilder sb, int cur){
        if(cur == str.length){
            if(sb.length() > 0){
                ret.add(sb.toString().toCharArray());
            }
        }else if(cur+1 == str.length || str[cur] != str[cur+1]){
            combinationCore(str, ret, sb.append(str[cur]), cur+1);
            sb.deleteCharAt(sb.length()-1);
            combinationCore(str, ret, sb, cur+1);
        }else{
            int dumplicateStart = cur;
            while(cur != str.length && str[cur] == str[dumplicateStart]){
                sb.append(str[cur]);
                cur++;
            }

            int newStart = cur;
            while(cur>=dumplicateStart){
                combinationCore(str, ret, sb, newStart);
                if (cur != dumplicateStart){
                    sb.deleteCharAt(sb.length()-1);
                }
                cur--;
            }
        }

    }

    public static void main(String[] args) {
        char[] str = {'a','a','b'};
        for (char val : str){
            System.out.print(val);
        }
        System.out.println();
        List<char[]> ret = combination(str);
        for (char[] val : ret){
            for (char val1 : val){
                System.out.print(val1);
            }
            System.out.print("\t");
        }
        System.out.println();
     }
}
