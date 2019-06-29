package swordOffer;

/**
 * @Author: Songxc
 * @Date: 23:56 2019/6/29
 * @Description: n个骰子的点数
 *  思路：
 *   规律：新加入骰子出现总和为n的次数等于加入之前总和为n-1，n-2,···,n-6的出现次数之和。
 *    可以通过循环实现。
 */
public class T60_DiceProbability {
    public static void diceProbability(int number){
        if (number<=1){
            return;
        }
        int[][] result = new int[2][6*number+1];
        for (int i=1;i<=6;i++){
             result[1][i] = 1;
        }
        for (int num =2;num<=number;num++){
            for (int i=num;i<6*num+1;i++){
                for (int j=i-6;j<i;j++){
                    if (j>0){
                        result[num%2][i] += result[(num-1)%2][j];
                    }
                }
            }
        }

        int sum =0;
        for (int i=number;i<6*number+1;i++){
            sum += result[number%2][i];
        }
        System.out.println("筛子个数："+number);
        for (int i=number;i<6*number+1;i++){
            System.out.println("probability:"+i+" => "+result[number%2][i]/(double)sum);
        }

    }

    public static void main(String[] args) {
        diceProbability(2);
    }

}
