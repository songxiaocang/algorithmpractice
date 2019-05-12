package swordOffer;

/**
 * @Author: Songxc
 * @Date: 18:16 2019/5/12
 * @Description: 调整数组顺序使奇数位于偶数前面
 * 思路：
 *   可通过实现一个公共判断函数来解决同类问题，定义两个指针位于起始位置，若前面是偶数，后面是奇数，则开始交换，直到两个指针相邻
 */
public class T21_ReorderArray {
    public static void reorder(int[] data){
        if(data == null || data.length<2){
            return;
        }
        int left = 0;
        int right = data.length-1;
        while(left<right){
            while(left<right&&!isEven(data[left])){
                left++;
            }
            while(left<right&&isEven(data[right])){
                right--;
            }

            if(left<right){
                int temp = data[left];
                data[left]=data[right];
                data[right]=temp;
            }
        }
    }

    public static boolean isEven(int val){
        return (val&1)==0;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,6,5};
        reorder(data);
        for (int val:
             data) {
            System.out.print(val+" ");
        }
    }
}
