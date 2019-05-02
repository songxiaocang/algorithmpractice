package swordOffer;

/**
 * @Author: Songxc
 * @Date: 17:23 2019/5/2
 * @Description: 斐波那契数列
 * 思路：
 * 解法       	解法介绍 	    时间复杂度 	空间复杂度
 * 解法1 	依定义递归求解 	       o(n^2) 	  o(1)
 * 解法2 	从0开始迭代求解 	       o(n) 	  o(1)
 * 解法3 	借助等比数列公式 	   o(logn) 	  o(1)
 * 解法4 	借助通项公式 	       o(1) 	  o(1)
 */
public class T10_Fibonacci {
    /**
     * 常规法：递归 O(n2)
     * @param n
     * @return
     */
    public static int fibonacci1(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci1(n-1) + fibonacci1(n-2);
    }

    /**
     * 动态规划：0(n)
     * @param n
     * @return
     */
    public static int fibonacci2(int n){
        int a = 0;
        int b = 1;
        int temp = 0;
        for (int i=2;i<=n;i++){
            temp = a + b;
            a = b;
            b =temp;
        }

        return temp;
    }

    /**
     * 等比数列公式
     * [f(n-1) f(n-2)] = [1 1]^n-1
     * [f(n-2) f(n-3)]   [1 0]
     * @param n
     * @return
     */
    public static int fibonacci3(int n){
        int[][] start = {{1,1},{1,0}};
        return matrixPow(start,n-1)[0][0];
    }

    public static int[][] matrixPow(int[][] start, int n){
        if((n&1) == 0){
            int[][] temp = matrixPow(start,n>>1);
            return matrixMulti(temp, temp);
        }else if(n == 1){
            return start;
        }else{
            return matrixMulti(start,matrixPow(start,n-1));
        }
    }

    public static int[][] matrixMulti(int[][] x,int[][] y){
        int[][] result = new int[x.length][y[0].length];
        for(int i=0;i<x.length;i++){
            for (int j=0;j<y.length;j++){
                int sum = 0;
                for(int k=0;k<x[0].length;k++){
                    sum+=x[i][k]*y[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    /**
     * 通项公式
     * @param n
     * @return
     *  f(n) =（1+√5）* ((1+√5)/2)^n - (1-√5)/2)^n)
     */
    public static int fibonacci4(int n){
        double gen5 = Math.sqrt(5);
        int result = (int) ((1/gen5)*( Math.pow((1+gen5)/2,n) - Math.pow((1-gen5)/2,n)));
        return result;
    }



    public static void main(String[] args) {
        System.out.println(fibonacci1(13));
        System.out.println(fibonacci2(13));
        System.out.println(fibonacci3(13));
        System.out.println(fibonacci4(13));
    }
}
