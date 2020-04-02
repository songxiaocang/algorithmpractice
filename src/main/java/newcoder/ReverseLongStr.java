package newcoder;

import java.util.Scanner;

/**
 * @Author: Songxc
 * @Date: 21:21 2020/3/24
 * @Description: 输入描述:
 * 将一个英文语句以单词为单位逆序排放。
 * 输出描述:
 * 得到逆序的句子
 * 输入
 * I am a boy
 * 输出
 * boy a am I
 */
public class ReverseLongStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
