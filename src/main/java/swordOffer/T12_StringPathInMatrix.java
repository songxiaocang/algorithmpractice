package swordOffer;

/**
 * @Author: Songxc
 * @Date: 19:16 2019/5/3
 * @Description: 设计一个函数，判断一个二维矩阵是否包含一个字符串所有字符的路径
 * 思路：
 *  运用回溯法
 *  需要明确递归的约束条件、回溯的终止条件、标记矩阵的标记和清除时机
 */
public class T12_StringPathInMatrix {
    public static boolean stringPathInMatrix(char[][] data,String str){
        if(data == null || data.length == 0){
            return false;
        }

        int rowLen = data.length;
        int colLen = data[0].length;

        boolean[][] visitFlag = new boolean[rowLen][colLen];
        for (int i=0;i<rowLen;i++){
            for (int j=0;j<colLen;j++){
                visitFlag[i][j] = false;
            }
        }

        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(hasPathCore(data,i,j,visitFlag,str,0)){
                    return true;
                }
            }
        }

        return false;
    }

     public static boolean hasPathCore(char[][] data,int row,int col,boolean[][] visitFlag,String str,int strIndex){
        if(strIndex>=str.length()){
            return true;
        }
        if (row < 0 || row>data.length || col<0 || col>data[0].length ){
            return false;
        }
        //递归
        if(!(visitFlag[row][col]) &&(data[row][col]==str.charAt(strIndex))){
            visitFlag[row][col] = true;
            boolean result = hasPathCore(data,row-1,col,visitFlag,str,strIndex+1)||
                    hasPathCore(data,row+1,col,visitFlag,str,strIndex+1)||
                    hasPathCore(data,row,col+1,visitFlag,str,strIndex+1)||
                    hasPathCore(data,row,col-1,visitFlag,str,strIndex+1);

            if (result){
                return true;
            }else{
                visitFlag[row][col] = false;
                return false;
            }
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] data = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}
        };
        System.out.println(stringPathInMatrix(data,"bfce"));
    }
}
