package swordOffer;

/**
 * @Author: Songxc
 * @Date: 12:07 2019/6/30
 * @Description: 构建乘积数组
 *  思路：
 *   可以采用二阶矩阵的方式实现，拆分成左右两部分计算求得。
 */
public class T66_ConstructArrays {
    public static int[] constructArrays(int[] data){
        if (data == null || data.length == 0){
            return null;
        }
        int[] result = new int[data.length];
        result[0] = 1;
        for (int i=1;i<result.length;i++){
            result[i] = result[i-1]*data[i-1];
        }
        int temp =1;
        for (int i=data.length-2;i>=0;i--){
            temp *= data[i+1];
            result[i] *= temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5};
        int[] result = constructArrays(data);
        for (int val : result){
            System.out.print(val+" ");
        }
    }
}
