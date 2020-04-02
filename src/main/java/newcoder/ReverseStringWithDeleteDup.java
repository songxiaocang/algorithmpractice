package newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Songxc
 * @Date: 20:32 2020/3/24
 * @Description:
 * 题目描述
 *
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 输入描述:
 *
 * 输入一个int型整数
 *
 * 输出描述:
 *
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 输入
 * 9876673
 *
 * 输出
 * 37689
 */
public class ReverseStringWithDeleteDup {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<Character, Integer> dataMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            char letter = input.charAt(i);
            if (dataMap.containsKey(letter)) {
                continue;
            } else {
                sb.append(letter + "");
                dataMap.put(letter, 1);
            }
        }
        System.out.println(Integer.valueOf(sb.toString()));
    }
}
