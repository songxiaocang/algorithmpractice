package sort;

/**
 * @Author: Songxc
 * @Date: 3:10 2019/4/27
 * @Description: 推排序
 * 思路： 建堆和堆调整的过程
 */
public class HeapSort {
    public static void heapSort(int[] a){
        int len = a.length;
        for(int i = len/2 - 1; i>=0; i-- ){
            heap(a,i,len-1);
        }

        for(int i=len-1;i>0;i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heap(a, 0, i-1);
        }
    }

    public static void heap(int[] a,int pos,int len){
        int child = 2*pos +1;
        int temp = a[pos];
        while(child<=len){
            if(child<len && a[child]<a[child+1]){
                child++;
            }
            if (a[child]>temp){
                a[pos] = a[child];
                pos = child;
                child = 2*pos+1;
            }else{
                break;
            }
        }
        a[pos] = temp;
    }

    public static void main(String[] args) {
        int[] a = {3, 8, 2, 4, 7, 9, 6};
        heapSort(a);
        for (int i = 0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
