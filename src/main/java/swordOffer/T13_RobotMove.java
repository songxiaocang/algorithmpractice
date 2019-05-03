package swordOffer;

/**
 * @Author: Songxc
 * @Date: 22:42 2019/5/3
 * @Description: 方格内机器人移动问题
 * 思路: 回溯算法
 * 思路与之前二维矩阵查找是否满足字符串的路径思路一致
 * 回溯条件：需要考虑边界值、各位数之和是否超过设置值、是否被访问过
 */
public class T13_RobotMove {
    public static int robotMove(int threshold, int rowLen, int colLen){
        if (threshold<0 || rowLen <= 0 || colLen <= 0 ){
            return 0;
        }
        boolean[][] visitFlag = new boolean[rowLen][colLen];
        for (int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                visitFlag[i][j] = false;
            }
        }

        return move(threshold, rowLen, colLen, 0, 0, visitFlag);
    }

    public static int move(int threshold, int rowLen, int colLen, int row, int col, boolean[][] visitFlag){
        int count = 0;
        if(canGetIn(threshold, rowLen, colLen, row, col, visitFlag)){
            visitFlag[row][col] =  true;
            count = 1+ move(threshold, rowLen, colLen, row-1, col,visitFlag)+
                    move(threshold, rowLen, colLen, row+1, col,visitFlag) +
                    move(threshold, rowLen, colLen, row, col-1, visitFlag) +
                    move(threshold, rowLen, colLen, row, col+1, visitFlag);
        }
        return count;
    }

    public static boolean canGetIn(int threshold, int rowLen, int colLen, int row, int col, boolean[][] visitFlag){
        return row>=0 && col>=0 && row<rowLen && col<colLen && !visitFlag[row][col] && (calSum(row) + calSum(col) <= threshold);
    }

    public static int calSum(int num){
        int sum = 0 ;
        while(num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(robotMove(0,3,4));
        System.out.println(robotMove(1,3,4));
        System.out.println(robotMove(9,2,20));
    }
}
