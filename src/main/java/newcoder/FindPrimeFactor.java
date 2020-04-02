package newcoder;

import java.util.Scanner;

/**
 * @Author: Songxc
 * @Date: 8:28 2020/3/24
 * @Description: 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（如180的质因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 * <p>
 * 详细描述：
 * 函数接口说明：
 * public String getResult(long ulDataInput)
 * <p>
 * 输入参数：
 * long ulDataInput：输入的正整数
 * <p>
 * 返回值：
 * String
 */
public class FindPrimeFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long params = sc.nextLong();
        if (params < 2) {
            sc.close();
            return;
        }
        String result = getResult(params);
        System.out.println(result);
        sc.close();

    }

    public static String getResult(long ulDataInput) {
        StringBuilder str = new StringBuilder();
        int index = 2;
        while (index <= ulDataInput) {
            if (ulDataInput % index == 0) {
                if (index == ulDataInput) {
                    str.append(index).append(" ");
                    break;
                } else {
                    str.append(index).append(" ");
                    ulDataInput = ulDataInput / index;
                }
            } else {
                index++;
            }
        }
        return str.toString();
    }
}
