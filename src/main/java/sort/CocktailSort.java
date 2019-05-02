package sort;

/**
 * @Author: Songxc
 * @Date: 0:15 2019/5/3
 * @Description:
 */
public class CocktailSort {
    public static void cocktailSort(int[] a){
        int left = 0;
        int right = a.length - 1;
        while(left<right){
            for(int i=left;i<right;i++){
                if(a[i]>a[i+1]){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
            right -- ;

            for(int j=right;j>left;j--){
                if(a[j-1]>a[j]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
                left++;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {1,3,2,5,4};
        cocktailSort(a);
        for (int val:a){
            System.out.print(val+" ");
        }
    }
}
