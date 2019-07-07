package leetcode;

/**
 * @Author: Songxc
 * @Date: 13:53 2019/7/7
 * @Description: 寻找两个有序数组的中位数
 *  思路：
 *   归并排序和 二分查找两种解法
 */
public class T4_FindMediumSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //归并排序
        if(nums1 == null && nums2 == null){
            return 0d;
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] num = new int[m+n];
        int i=0,j=0,k=0;
        while(i<=m-1 && j<=n-1){
            if(nums1[i]>nums2[j]){
                num[k++]=nums2[j++];
            }else{
                num[k++]=nums1[i++];
            }
        }
        while(i<=m-1){
            num[k++]=nums1[i++];
        }
        while(j<=n-1){
            num[k++]=nums2[j++];
        }

        if(num.length%2==0){
            return (double)(num[num.length/2]+num[num.length/2-1])/2;
        }else{
            return (double)(num[num.length/2]);
        }

    }

    public static void main(String[] args) {
        int[] num1={1,2};
        int[] num2={3,4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
