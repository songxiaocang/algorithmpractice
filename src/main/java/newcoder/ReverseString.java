package newcoder;

import java.util.Scanner;

/**
 * @Author: Songxc
 * @Date: 21:12 2020/3/24
 * @Description: 输入描述:
 * 输入一个int整数
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 * 1516000
 * 输出
 * 0006151
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        String output = sb.reverse().toString();
        System.out.println(output);
    }
}
