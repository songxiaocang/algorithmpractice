package swordOffer;

/**
 * @Author: Songxc
 * @Date: 20:06 2019/6/23
 * @Description:  有序数组中和为s的数字
 *  思路：
 *   类似于二分查找
 */
public class T57_FindNumberWithSum {
    public static int[] findNumbersWithSum(int[] data, int sum){
        if (data==null || data.length==0){
            return null;
        }
        int[] result = {0,0};
        int left = 0;
        int right =data.length -1;
        int curSum = data[left] + data[right];
        while(curSum != sum && left <right){
            if (curSum>sum){
                right--;
            }
            if (curSum < sum){
                left++;
            }
            curSum = data[left]+data[right];
        }
        if (curSum == sum){
            result[0] = data[left];
            result[1] = data[right];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,2,4,7,11,15};
        int[] result = findNumbersWithSum(data, 15);
        System.out.println(result[0]+" " +result[1]);
    }
}
