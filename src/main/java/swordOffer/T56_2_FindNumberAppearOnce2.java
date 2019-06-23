package swordOffer;

/**
 * @Author: Songxc
 * @Date: 19:46 2019/6/23
 * @Description:  数组中只出现一次的数字（其余的数字出现都为三次）
 *  思路：
 *   使用32位定长辅助数组存储数组各元素之和，然后对3取余数，返回该值即可。
 */
public class T56_2_FindNumberAppearOnce2 {
    public static int findNumberAppearOnce2(int[] data){
        if (data == null || data.length==0){
            return -1;
        }
        int[] bitSum = new int[32];
        for(int i=0;i<data.length;i++){
            int bitMask = 1;
            for (int j=31;j>=0;j--){
                int bit = data[i]&bitMask;
                if (bit!=0){
                    bitSum[j]+=1;
                }
                bitMask = bitMask<<1;
            }
        }
        int result = 0;
        for(int k=0;k<32;k++){
            result = result<<1;
            result+=bitSum[k]%3;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] data = { 8, 6, 7, 8, 8, 6, 6};
        System.out.println(findNumberAppearOnce2(data));
    }
}
