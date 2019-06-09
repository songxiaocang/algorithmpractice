package swordOffer;

/**
 * @Author: Songxc
 * @Date: 20:35 2019/6/9
 * @Description: 数字序列中某一位的数字
 * 思路：
 *   观察出数学规律，求解。
 *   该序列有0-9 10-99 100-999这些一次递增的k位数相互拼接而成。
 *   需要找出第N位对应几位数，及该几位数中哪一个数字和具体的哪一位。
 */
public class T45_DigitsOfIndex {
    public static int digitOfIndex(int index){
        if (index < 0){
            return -1;
        }
        if (index < 10){
            return index;
        }
        int curIndex = 10;
        int length = 2;
        int bound = 10;
        while(curIndex+getLength(length) < index){
            curIndex+=getLength(length);
            bound*=10;
            length++;
        }
        int addNum = (index - curIndex)/length;
        int finalNum = bound + addNum;
        return String.valueOf(finalNum).charAt(index - curIndex - addNum*length) - '0';
    }

    public static int getLength(int length){
        int count = 9;
        for(int i=1; i<length; i++){
            count *= 10;
        }

        return count * length;
    }

    public static void main(String[] args) {
        for(int i=9;i<16;i++)
            System.out.println(digitOfIndex(i));
        System.out.println(digitOfIndex(1001));

    }
}
