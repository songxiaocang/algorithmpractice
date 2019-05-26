package swordOffer;

/**
 * @Author: Songxc
 * @Date: 15:20 2019/5/26
 * @Description: 顺时针打印矩阵
 *  思路：
 *   每圈打印的必须条件是 cols>start*2  && rows>start*2
 *   然后从左到右、从上到下、从右到左、从下到上依次遍历打印（注意满足当前行或列打印条件）
 */
public class T29_PrintMatrixInCircle {
    public static void printMatrixInCircle(int[][] data){
        if(data == null || data.length == 0 || data[0].length == 0){
            return;
        }
        int rows = data.length;
        int cols = data[0].length;
        int start = 0;
        while(rows>2*start && cols>2*start){
            printMatrixInCircle(data, rows, cols, start);
            start++;
        }
    }

    public static void printMatrixInCircle(int[][] data, int rows, int cols, int start){
        int endX = cols-1-start;
        int endY = rows-1-start;
        for(int i=start;i<=endX;i++){
            System.out.print(data[start][i]+" ");
        }

        if(start<endY){
            for(int i=start+1;i<=endY;i++){
                System.out.print(data[i][endX]+" ");
            }
        }

        if(start<endX && start<endY){
            for (int i=endX-1;i>=start;i--){
                System.out.print(data[endY][i]+" ");
            }
        }

        if(start<endX && start<endY-1){
            for(int i=endY-1;i>=start+1;i--){
                System.out.print(data[i][start]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] data1={
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7},
        };
        int[][] data2={
                {1,2,3,4},
                {10,11,12,5},
                {9,8,7,6},
        };
        int[][] data3={
                {1,2,3},
                {10,11,4},
                {9,12,5},
                {8,7,6},
        };
        int[][] data4={
                {1,2,3},
                {8,9,4},
                {7,6,5},
        };

        printMatrixInCircle(data1);
        System.out.println();
        printMatrixInCircle(data2);
        System.out.println();
        printMatrixInCircle(data3);
        System.out.println();
        printMatrixInCircle(data4);
    }
}
