package sort;

/**
 * @Author: Songxc
 * @Date: 0:20 2019/5/3
 * @Description: 直接选择排序 时间复杂度：最坏：O(n2) 最好O(n2) 平均0(n2)  空间复杂度：0(1)
 */
public class SelectSort {
    public static void selectSort(int[] a){
        int n=a.length;
        for(int i=0;i<n;i++){
            int k = i;
            for(int j=i+1;j<n;j++){
                if(a[i]>a[j]){
                    k = j;
                }
            }

            if(k>i){
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,5,4};
        selectSort(a);
        for (int val:a){
            System.out.print(val+" ");
        }
    }
}
