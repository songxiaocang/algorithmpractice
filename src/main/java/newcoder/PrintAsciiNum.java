package newcoder;

import java.util.Scanner;

/**
 * @Author: Songxc
 * @Date: 20:59 2020/3/24
 * @Description:
 *  题目描述
 *
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 * 输入描述:
 *
 * 输入N个字符，字符在ACSII码范围内。
 *
 * 输出描述:
 *
 * 输出范围在(0~127)字符的个数。
 *
 *       输入
 *       abc
 *      输出
 *       3
 */
public class PrintAsciiNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int hitCount = 0;
        int[] arr = new int[128];
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i)] = 1;
        }

        for (int val : arr) {
            if (val > 0) {
                hitCount++;
            }
        }

        System.out.println(hitCount);
    }
}
