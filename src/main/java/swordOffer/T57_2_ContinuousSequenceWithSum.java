package swordOffer;

/**
 * @Author: Songxc
 * @Date: 21:47 2019/6/23
 * @Description: 和为s的连续正数序列
 *  思路：
 *   采用前后指针遍历
 */
public class T57_2_ContinuousSequenceWithSum {
    public static void continuousSequenceWithSum(int sum){
        if (sum<=0){
            return;
        }
        int small=1,big=2,middle = sum>>1;
        int curSum=small+big;
        while(small<=middle){
            if (curSum==sum){
                printSequence(small,big);
            }
            while(curSum>sum && small <= middle){
                curSum -= small;
                small++;
                if (curSum == sum) {
                    printSequence(small,big);
                }
            }

            big++;
            curSum+=big;

        }
    }

    public static void printSequence(int small,int big){
        for (int i=small;i<=big;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        continuousSequenceWithSum(15);
    }
}
