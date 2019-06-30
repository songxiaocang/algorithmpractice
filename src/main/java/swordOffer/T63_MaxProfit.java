package swordOffer;

/**
 * @Author: Songxc
 * @Date: 9:54 2019/6/30
 * @Description: 股票买卖的最大利润
 *  思路：
 *   使用一个变量记录最小买入价，并与当前值作比较，差值最大即求解。
 */
public class T63_MaxProfit {
    public static int maxProfit(int[] data){
        if (data==null || data.length <=1){
            return -1;
        }
        int min = data[0];
        int maxDiff = data[1] - min;
        for (int i=2;i<data.length;i++){
            if (data[i]-min>maxDiff){
                maxDiff = data[i]-min;
            }
            if (data[i]< min){
                min = data[i];
            }
        }
        return maxDiff;
    }


    public static void main(String[] args) {
        int[] data = {9,11,8,5,7,12,16,14};
        int[] data2 = {9,8,7,6,5,4,3,1};
        System.out.println(maxProfit(data));
        System.out.println(maxProfit(data2));
    }
}
