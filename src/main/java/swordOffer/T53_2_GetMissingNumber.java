package swordOffer;

/**
 * @Author: Songxc
 * @Date: 1:49 2019/6/17
 * @Description: 0~n-1 中缺失的数字
 *  思路：
 *   可以理解为第一个数字索引下标和值不相等的数字即为缺失的数字，可以通过二分查找实现
 *
 */
public class T53_2_GetMissingNumber {
    public static int getMissingNumber(int[] data){
        if (data == null || data.length == 0){
            return -1;
        }
        int low = 0,high = data.length -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if (data[mid] == mid){
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }

        if (low == data.length){
            return -1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{0,1,2,3,4,5}; //-1
        int[] data2 = new int[]{0,1,3,4,5}; //2
        int[] data3 = new int[]{1,2}; //0
        System.out.println(getMissingNumber(data1));
        System.out.println(getMissingNumber(data2));
        System.out.println(getMissingNumber(data3));

    }
}
