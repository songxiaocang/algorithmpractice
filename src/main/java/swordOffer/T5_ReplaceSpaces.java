package swordOffer;

/**
 * @Author: Songxc
 * @Date: 0:50 2019/4/26
 * @Description: 替换空格为%20
 * 思路：数组扩容，从后往前复制
 */
public class T5_ReplaceSpaces {
    //由于java的字符数组没有结束符，所以需要多传入个原始长度
    //先计算好替换后的位置，从后向前替换，时间复杂度o(n)
    public static void replaceBlank(char[] data,int length){
        int newLength = length;
        for(int i=0;i<length;i++){
            if(data[i]==' ')
                newLength += 2;
        }
        for(int indexOfOld = length-1,indexOfNew=newLength-1;indexOfOld>=0 && indexOfOld!=indexOfNew;indexOfOld--,indexOfNew--){
            if(data[indexOfOld]==' '){
                data[indexOfNew--] = '0';
                data[indexOfNew--] = '2';
                data[indexOfNew] = '%';
            }
            else{
                data[indexOfNew] = data[indexOfOld];
            }
        }
    }
    public static void main(String[] args){
        char[] predata = "We are happy.".toCharArray();
        char[] data = new char[20];
        for(int i=0;i<predata.length;i++)
            data[i] = predata[i];
        System.out.println(data);
        replaceBlank(data,13);
        System.out.println(data);
    }
}
