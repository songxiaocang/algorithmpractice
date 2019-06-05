package swordOffer;

/**
 * @Author: Songxc
 * @Date: 23:45 2019/6/5
 * @Description:  数组中出现次数超过一半的元素
 *  思路；
 *   有两种解决办法：快速排序、分区算法 时间复杂度为0(N)； 用一个数组缓存命中的元素和count记录命中的次数，利用数组特点求出目标元素，时间复杂度为0(n)，空间复杂度为O(1)
 *
 */
public class T39_MoreThanHalfOfNumber {
    //快排
    public static Integer solution1(int[] data){
        if (data == null || data.length == 0){
            return null;
        }
        int k = data.length >> 1;
        int left = 0;
        int right = data.length - 1;
        int index = partition(data, left, right);
        while(index != k){
            if(index < k){
                index = partition(data, index+1, right);
            }else{
                index = partition(data, left, index-1);
            }
        }

        return data[k];
    }

    public static int partition(int[] data, int left, int right){
        int pivot = data[left];
        while(left < right){
            while(left < right && data[right] >= pivot){
                right--;
            }
            if(left < right){
                data[left] = data[right];
            }
            while(left < right && data[left] <= pivot){
                left++;
            }
            if(left < right){
                data[right] = data[left];
            }
        }
        data[left] = pivot;

        return left;
    }

    //数组特点
    public static Integer solution2(int[] data){
        if(data == null || data.length == 0){
            return null;
        }
        int count = 1;
        int value = data[0];
        for(int i=1;i<data.length;i++){
            if(data[i]==value){
                count++;
            }else if(data[i]!=value && count==1){
                value = data[i];
            }else{
                count--;
            }
        }

        return value;
    }


    public static void main(String[] args) {
        int[] data = {1,3,4,5,2,2,2,2,2};
        System.out.println(solution1(data));
        System.out.println(solution2(data));
    }
}
