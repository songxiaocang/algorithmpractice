package swordOffer;

/**
 * @Author: Songxc
 * @Date: 0:40 2019/6/30
 * @Description: 扑克牌中的顺子
 *  思路：
 *   使用哈哈希表存储输入数字出现的次数，并以此排序（时间复杂度为0(n)）,然后遍历哈希表满足数字前后连续
 *   或者用0位数字个数补充缺失数字可行的话，即满足顺子要求，否则不可行。
 */
public class T61_ContinuousCard {
    public static boolean isContinuous(int[] data){
        if (data == null || data.length==0 || data.length < 5){
            return false;
        }
        int[] table = new int[14];
        for (int i=0;i<data.length;i++){
            if (data[i]>13 || data[i] < 0){
                return false;
            }
            table[data[i]]++;
        }
        int start = 1;
        while(table[start] == 0){
            start++;
        }
        int king = table[0];
        for (int i=start;i<start+5 && i<=13;i++){
            if (table[i]>13 || table[i] < 0 || table[i]>1){
                return false;
            }
            if (table[i] == 0){
                if (king <=0){
                    return false;
                }else{
                    king --;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] data = {0,1,3,4,6};
        int[] data2 = {4,2,7,12,1};
        System.out.println(isContinuous(data2));
    }
}
