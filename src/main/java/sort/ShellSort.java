package sort;

/**
 * @Author: Songxc
 * @Date: 0:54 2019/4/27
 * @Description:  希尔排序 时间复杂度：最坏：O(n2) 最好O(n) 平均0(n1.3)  空间复杂度：0(1)
 */
public class ShellSort {
    public static void shellSort(int[] array) {
        int n = array.length;
        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                for (int j = i - h; j >= 0; j -= h) {
                    if (array[j] > array[j + h]) {
                        int temp = array[j];
                        array[j] = array[j + h];
                        array[j + h] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 8, 2, 4, 7, 9, 6};
        shellSort(a);
        for (int val : a){
            System.out.print(val + " ");
        }
    }
}
