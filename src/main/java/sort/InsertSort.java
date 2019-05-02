package sort;

/**
 * @Author: Songxc
 * @Date: 0:06 2019/5/3
 * @Description: 直接插入排序 时间复杂度：最坏：O(n2) 最好O(n) 平均0(n2)  空间复杂度：0(1)
 */
public class InsertSort {
    public static void insertSort(int[] a){
        int n = a.length;
        for (int i=1; i< n; i++){
            for(int j=i;j>0;j--){
                if(a[j-1]>a[j]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {1,3,2,5,4};
        insertSort(a);
        for (int val:a){
            System.out.print(val+" ");
        }
    }
}
