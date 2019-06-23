package swordOffer;

/**
 * @Author: Songxc
 * @Date: 18:22 2019/6/23
 * @Description: 数组中只出现一次的两个数字
 *  思路：
 *   使用异或运算找出值为1的数位，然后进行分组，分组异或求出最终值。
 */
public class T56_FindNumberAppearOnce {
    public static int[] findNumberAppearOnce(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        int result = 0;
        for (int val : data) {
            result ^= val;
        }
        int index = findIndexOfBit1(result);
        int[] ret = {0, 0};
        if (index <= 0) {
            return ret;
        }
        for (int i = 0; i < data.length; i++) {
            if ((data[i] & index) == 0) {
                ret[0] ^= data[i];
            } else {
                ret[1] ^= data[i];
            }
        }
        return ret;
    }

    public static int findIndexOfBit1(int num) {
        if (num <= 0) {
            return -1;
        }
        int index = 1;
        while (num > 0) {
            if ((num & 1) == 1) {
                return index;
            } else {
                num = num >> 1;
                index = index * 2;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        int[] result = findNumberAppearOnce(data);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
