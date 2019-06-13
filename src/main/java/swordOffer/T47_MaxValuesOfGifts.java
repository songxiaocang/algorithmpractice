package swordOffer;

/**
 * @Author: Songxc
 * @Date: 23:37 2019/6/12
 * @Description:  礼物的最大值
 *  思路：
 *   有两种解决办法: 动态规划，广度优先遍历
 *   动态规划：当前礼物的最大值与当前行和上一行的值有关，可以使用一个一维数组递归求出。
 *
 */
public class T47_MaxValuesOfGifts {
    public static int maxValuesOfGifts(int[] data, int rows, int cols){
        if(data == null || data.length == 0){
            return -1;
        }
        int[] maxValues = new int[cols];
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                int left = 0;
                int up = 0;
                if (i > 0){
                    up = maxValues[j];
                }
                if (j > 0){
                    left = maxValues[j-1];
                }

                maxValues[j] = max(left, up) + data[i*cols+j];
            }

        }
        int maxValue = maxValues[cols-1];
        return maxValue;
    }


    public static int max(int val1, int val2){
        if (val1 > val2){
            return val1;
        }
        return val2;
    }

    public static void main(String[] args) {
//        int[] data = { 1,10,3,8,12,2,9,6,5,7,4,11,3,7,16,5};
        int[] data = { 1, 10, 3, 8, 12, 2, 9, 6, 5, 7, 4, 11, 3, 7, 16, 5 };
        System.out.println(maxValuesOfGifts(data,4,4));
    }
}
