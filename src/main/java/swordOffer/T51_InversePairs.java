package swordOffer;

/**
 * @Author: Songxc
 * @Date: 15:16 2019/6/16
 * @Description: 数组中的逆序对
 *  思路：
 *   使用两路归并排序实现，实现复杂度为0(nlogn)，空间复杂度为0(n)
 */
public class T51_InversePairs {
    public static int inversePars(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        return inversePairsCore(data, 0, data.length - 1);
    }

    public static int inversePairsCore(int[] data, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = (low + high) / 2;
        int left = inversePairsCore(data, low, mid);
        int right = inversePairsCore(data, mid + 1, high);
        int count = inversePairsCore(data, low, mid, high);
        return left + right + count;
    }

    public static int inversePairsCore(int[] data, int low, int mid, int high) {
        int i = mid;
        int j = high;
        int[] temp = new int[high - low + 1];
        int index = high - low;
        int count = 0;
        while (i >= low && j >= mid + 1) {
            if (data[i] > data[j]) {
                temp[index--] = data[i--];
                count += j - mid;
            } else {
                temp[index--] = data[j--];
            }
        }

        while (i >= low) {
            temp[index--] = data[i--];
        }
        while (j >= mid + 1) {
            temp[index--] = data[j--];
        }

        for (int k = 0; k < temp.length; k++) {
            data[low + k] = temp[k];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] data = {7, 5, 6, 4};
        int[] data2 = {5, 6, 7, 8, 1, 2, 3, 4};
        System.out.println(inversePars(data));
//        System.out.println(inversePars(data2));
    }
}
