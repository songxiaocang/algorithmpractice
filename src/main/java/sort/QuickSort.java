package sort;

/**
 * @Author: Songxc
 * @Date: 23:38 2019/4/25
 * @Description: 快速排序
 */
public class QuickSort {
    public static void quickSort(int[] a,int low,int high){
        if (low>=high){
            return;
        }
        int i = low;
        int j= high;
        int key = a[i];
        while(i < j){
            while(i < j && a[j] > key){
                j--;
            }
            a[i++]=a[j];

            while(i<j && a[i] < key){
                i++;
            }
            a[j--] = a[i];
        }

        a[i] = key;
        quickSort(a,low,i-1);
        quickSort(a,i+1,high);
    }

    public static void main(String[] args){
        int[] a = {3, 8, 2, 4, 7, 9, 6};
        quickSort(a,0,a.length -1);
        for (int i:a){
            System.out.print(i+ " ");
        }
    }
}
