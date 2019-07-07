package leetcode;

/**
 * @Author: Songxc
 * @Date: 13:53 2019/7/7
 * @Description: 寻找两个有序数组的中位数
 * 思路：
 * 归并排序和 二分查找两种解法
 */
public class T4_FindMediumSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //归并排序,时间复杂度为0（log(m+n)）
        if (nums1 == null && nums2 == null) {
            return 0d;
        }
        int m = nums1.length;
        int n = nums2.length;
        int[] num = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i <= m - 1 && j <= n - 1) {
            if (nums1[i] > nums2[j]) {
                num[k++] = nums2[j++];
            } else {
                num[k++] = nums1[i++];
            }
        }
        while (i <= m - 1) {
            num[k++] = nums1[i++];
        }
        while (j <= n - 1) {
            num[k++] = nums2[j++];
        }

        if (num.length % 2 == 0) {
            return (double) (num[num.length / 2] + num[num.length / 2 - 1]) / 2;
        } else {
            return (double) (num[num.length / 2]);
        }

    }

    //二分查找法,时间复杂度为0(log(m,n))
    public static double findMediumSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int iMin = 0, iMax = m, i = 0, j = 0;
        while (iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = (m + n + 1) / 2 - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return ((double) (maxLeft + minRight)) / 2;
            }
        }
        return 0d;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(findMedianSortedArrays(num1, num2));
        System.out.println(findMediumSortedArrays2(num1, num2));
    }
}
