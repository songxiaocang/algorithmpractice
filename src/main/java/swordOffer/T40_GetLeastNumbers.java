package swordOffer;

/**
 * @Author: Songxc
 * @Date: 18:07 2019/6/7
 * @Description:  最小的K个数 （topK）
 *  思路：
 *   有两种解法：快速排序partion分区算法  和 堆排序，前者时间复杂度为0(N),后者时间复杂度为0(nlogk)
 *    后者更适合海量数据topK问题求解（在内存有限情况下）。
 */
public class T40_GetLeastNumbers {
    //分区函数
    public static int[] solution1(int[] data, int k) {
        if (data == null || data.length == 0 || k > data.length) {
            return null;
        }
        int left = 0;
        int right = data.length - 1;
        int index = partition(data, left, right);

        while (index != k - 1) {
            if (index > k - 1) {
                index = partition(data, left, index - 1);
            } else {
                index = partition(data, index + 1, right);
            }
        }

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = data[i];
        }

        return output;

    }

    public static int partition(int[] data, int left, int right) {
        int pivot = data[left];
        while (left < right) {
            while (left < right && data[right] > pivot) {
                right--;
            }
            if (left < right) {
                data[left] = data[right];
            }
            while (left < right && data[left] < pivot) {
                left++;
            }
            if (left < right) {
                data[right] = data[left];
            }
        }

        data[left] = pivot;
        return left;
    }


    // 堆排序
    public static int[] solution2(int[] data, int k) {
        if (data == null || data.length == 0 || k > data.length) {
            return null;
        }
        int[] newData = new int[k];
        for (int i = 0; i < k; i++) {
            newData[i] = data[i];
        }
        for (int i = k / 2 - 1; i > 0; i--) {
            heapAdjust(newData, i, k - 1);
        }

        for (int i = k; i < data.length; i++) {
            if (data[i] < newData[0]) {
                newData[0] = data[i];
                heapAdjust(newData, 0, k);
            }
        }
        return newData;
    }

    public static void heapAdjust(int[] data, int pos, int len) {
        int leftChild = pos * 2 + 1;
        int rightChild = pos * 2 + 2;
        int max = pos;
        if (leftChild < len && data[leftChild] > data[max]) {
            max = leftChild;
        }
        if (rightChild < len && data[rightChild] > data[max]) {
            max = rightChild;
        }

        if (max != pos) {
            int temp = data[pos];
            data[pos] = data[max];
            data[max] = temp;
            heapAdjust(data, max, len);
        }
    }

    public static void main(String[] args) {
        int[] data1 = {6, 1, 3, 5, 4, 2};
        int[] data2 = {8, 9, 3, 5, 7, 2};

        int[] newData2 = solution2(data2, 3);
        for (int val : newData2) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[] newData = solution1(data1, 3);
        for (int val : newData) {
            System.out.print(val + " ");
        }
        System.out.println();

    }

}
