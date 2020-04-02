package newcoder;

import java.util.Scanner;

/**
 * @Author: Songxc
 * @Date: 8:40 2020/3/24
 * @Description: 题目描述
 * <p>
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * 输入描述:
 * <p>
 * 输入一个正浮点数值
 * <p>
 * 输出描述:
 * <p>
 * 输出该数值的近似整数值
 */
public class NumRoundUp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        double inputNum = Double.parseDouble(input);
        double partNum = Integer.parseInt(input.substring(0, 1));
        double leftDistance = inputNum - partNum;
        double rightDistance = partNum + 1 - inputNum;
        if (rightDistance <= leftDistance) {
            System.out.println((int) (partNum + 1));
        } else {
            System.out.println((int) partNum);
        }
    }

}
