package swordOffer;

/**
 * @Author: Songxc
 * @Date: 1:11 2019/4/25
 * @Description:
 *  面试题4：二维数组，从左到右递增，从上到下递增，输入一个整数，判断数组中是否含有
 *  思路：建议从右上角作为起始点(左下角也行)，不建议从左上角或者右下角作为七十点
 *      从右上角出发，逐步筛选匹配的过程
 */
public class T4_FindInPartiallySortedMatrix {
    public static boolean findInPartiallySortedMatrix(int[][] data,int target){
        if(data==null ||data.length==0 || data[0].length==0)
            return false;
        int rowMax = data.length-1,colMax = data[0].length-1;
        int rowCur = 0,colCur = data[0].length - 1;
        while(true){
            if(rowCur<0 | rowCur>rowMax | colCur<0 | colCur>colMax)
                return false;
            if(data[rowCur][colCur]==target)
                return true;
            else if(data[rowCur][colCur]>target)
                colCur--;
            else
                rowCur++;
        }
    }
    public static void main(String[] args){
        int[][] data = {{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        System.out.println(findInPartiallySortedMatrix(data, 10));
        System.out.println(findInPartiallySortedMatrix(data, 5));
    }
}
