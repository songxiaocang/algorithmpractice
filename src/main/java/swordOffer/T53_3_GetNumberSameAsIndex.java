package swordOffer;

/**
 * @Author: Songxc
 * @Date: 0:16 2019/6/20
 * @Description: 数组中数值和下标相等的元素
 *  思路：
 *   二分查找法
 */
public class T53_3_GetNumberSameAsIndex {
    public static int getNumberSameAsIndex(int[] data){
        if (data == null || data.length == 0){
            return -1;
        }
        if (data[0] > 0 || data[data.length-1] < data.length-1){
            return -1;
        }
        int left=0,right=data.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if (data[mid]==mid){
                return mid;
            }else if(data[mid]>mid){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getNumberSameAsIndex(new int[]{-3,-1,1,3,5})); //3
        System.out.println(getNumberSameAsIndex(new int[]{0,1,2,3,4}));   //0~4
        System.out.println(getNumberSameAsIndex(new int[]{4,5,6,7,8}));   //-1
    }
}
