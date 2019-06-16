package swordOffer;

/**
 * @Author: Songxc
 * @Date: 23:40 2019/6/16
 * @Description:  数字在排序数组中出现的次数
 *  思路：
 *   基于二分查找实现，有递归和非递归两个版本。（时间复杂度为0(logn)）
 */
public class T53_GetNumberOfK {

    //二分查找（非递归版本）
    public static int solution1(int[] data, int k) {
        if (data == null || data.length == 0) {
            return -1;
        }
        int left = getStartIndexOfK(data, k, 0, data.length - 1);
        int right = getEndIndexOfK(data, k, 0, data.length - 1);
        if (left >= right) {
            return -1;
        }
        return right - left + 1;
    }

    public static int getStartIndexOfK(int[] data, int k, int low, int high) {
        while (low <= high) {
            if (low == high) {
                if (data[low] == k) {
                    return low;
                } else {
                    return -1;
                }

            }
            int mid = low + (high - low) / 2;

            if (data[mid] > k) {
                high = mid - 1;
            } else if (data[mid] < k) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }
        return -1;
    }

    public static int getEndIndexOfK(int[] data, int k, int low, int high) {
        while (low <= high) {
            if (low == high) {
                if (data[low] == k) {
                    return low;
                } else {
                    return -1;
                }

            }
            int mid = low + (high - low + 1) / 2;

            if (data[mid] > k) {
                high = mid - 1;
            } else if (data[mid] < k) {
                low = mid + 1;
            } else {
                low = mid;
            }

        }
        return -1;
    }

    //二分查找（递归版本）
    public static int solution2(int[] data, int k) {
        if (data == null || data.length == 0) {
            return -1;
        }
        int left = getStartIndexOfK2(data, k, 0, data.length - 1);
        int right = getEndIndexOfK2(data, k, 0, data.length - 1);
        if (left >= right) {
            return -1;
        }
        return right - left + 1;
    }

    public static int getStartIndexOfK2(int[] data, int k, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        int midData = data[mid];
        if (midData == k) {
            if (mid == 0 || (mid > 0 && data[mid - 1] != k)) {
                return mid;
            } else {
                high = mid - 1;
            }
        } else if (midData > k) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }

        return getStartIndexOfK2(data, k, low, high);
    }

    public static int getEndIndexOfK2(int[] data, int k, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        int midData = data[mid];
        if (midData == k) {
            if (mid == data.length - 1 || (mid < data.length - 1 && data[mid + 1] != k)) {
                return mid;
            } else {
                low = mid + 1;
            }
        } else if (midData > k) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }

        return getEndIndexOfK2(data, k, low, high);
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{1, 2, 3, 3, 3, 3, 5, 6};
        int[] data2 = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        int[] data3 = new int[]{3, 3, 3, 3, 3, 3, 3, 3};
        System.out.println(solution1(data1, 0));
        System.out.println(solution2(data1, 0));
        System.out.println(solution1(data2, 3));
        System.out.println(solution2(data2, 3));
        System.out.println(solution1(data3, 3));
        System.out.println(solution2(data3, 3));
    }
}
