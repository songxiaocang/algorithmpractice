package swordOffer;

/**
 * @Author: Songxc
 * @Date: 16:29 2019/5/3
 * @Description: 查找有序旋转数组的最小数字
 * 思路：
 *  定义两个指针，分别指向最左和最有，然后进行二分查找，对于特殊情况，最左小于最右边的值，直接返回；
 *  对于最左等于最右值，若最左=最右=中间值，顺序依次比较，否则进行二分查找；对于最左大于最右值，进行二分查找。
 */
public class T11_MinNumInRotatedArray {
    public static int minNumInRotatedArray(int[] a){
        if (a == null || a.length == 0){
            return -1;
        }

        int left = 0;
        int right = a.length - 1;
        while(left<right){
            int mid = (left+right)/2;
            if (a[left]<a[right]){
                return a[left];
            }else if(a[left]>a[right]){
                if(a[mid]>=a[left]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                if(a[mid]>a[left]){
                    left = mid + 1;
                }else if(a[mid]<a[left]){
                    right = mid - 1;
                }else{
                    left = left + 1;
                    right = right - 1;
                }
            }
        }
        return a[right];
    }


    public static void main(String[] args) {
        int[] data1 = {3,4,5,1,2};
        int[] data2 = {1,0,1,1,1};
        int[] data3 = {1,1,1,0,1};

        System.out.println(minNumInRotatedArray(data1));
        System.out.println(minNumInRotatedArray(data2));
        System.out.println(minNumInRotatedArray(data3));

    }
}
