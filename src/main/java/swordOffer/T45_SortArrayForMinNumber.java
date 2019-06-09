package swordOffer;

/**
 * @Author: Songxc
 * @Date: 21:35 2019/6/9
 * @Description: 把数组排列成最小的数字
 *  思路：
 *   找出求解规律，有点类似与冒牌排序，需要重新定义一种比较规则（字符串比较），时间复杂度为0(nlogn)
 */
public class T45_SortArrayForMinNumber {
    public static void sortArrayForMinNumber(int[] data){
        if (data == null || data.length == 0){
            System.out.println("输入数组格式不正确");
            return;
        }
        for (int i=0;i<data.length-1;i++){
            for (int j=0;j<data.length-i-1;j++){
                if (compare(data[j],data[j+1])){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }

        for (int val : data){
            System.out.print(val+" ");
        }

    }

    public static boolean compare(int data1, int data2){
        String str1 = data1 + "" + data2;
        String str2 = data2 + "" + data1;
        if (str1.compareTo(str2) > 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        sortArrayForMinNumber(new int[]{3, 32, 321});
    }
}
