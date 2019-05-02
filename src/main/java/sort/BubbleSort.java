package sort;

/**
 * @Author: Songxc
 * @Date: 0:11 2019/5/3
 * @Description: 冒泡排序 时间复杂度：最坏：O(n2) 最好O(n) 平均0(n2)  空间复杂度：0(1)
 */
public class BubbleSort {
    public static void bubbleSort(int[] a){
        int n = a.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,5,4};
        bubbleSort(a);
        for (int val:a){
            System.out.print(val+" ");
        }
    }
}
