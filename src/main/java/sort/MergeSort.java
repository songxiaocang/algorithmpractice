package sort;

/**
 * @Author: Songxc
 * @Date: 23:48 2019/4/25
 * @Description: 归并排序  时间复杂度：最坏：O(nlogn) 最好O(nlogn) 平均0(nlogn)  空间复杂度：0(n)
 *  思路：
 *      两路归并到新的序列中
 */
public class MergeSort {
    public static void mergeSort(int[] a, int low, int high){
        int mid = (low + high) / 2;
        if (low < high){
            mergeSort(a, low, mid);
            mergeSort(a,mid+1, high);
            merge(a, low, mid, high);
        }


    }

    public static void merge(int[] a, int low, int mid, int high){
        int[] temp  = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while(i<=mid && j <= high){
            if (a[i] < a[j] ){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }

        while(i<=mid){
            temp[k++] = a[i++];
        }
        while(j<=high){
            temp[k++] = a[j++];
        }

        for(int m=0; m<temp.length; m++){
            a[m+low] = temp[m];
        }

    }

    public static void main(String[] args){
        int[] a = {3, 8, 2, 4, 7, 9, 6};
        mergeSort(a,0,a.length -1);
        for (int i = 0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
