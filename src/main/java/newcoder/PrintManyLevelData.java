package newcoder;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: Songxc
 * @Date: 22:06 2020/3/24
 * @Description:
 *  多层数据排序
 *  * Apple 4 20
 *  * Apple 3 10
 *  * Orange 2 15
 *  * Orange 5 10
 *  * Banana 1 5
 */
public class PrintManyLevelData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SortedMap<String, SortedMap<Integer, Integer>> dataMap = new TreeMap<String, SortedMap<Integer, Integer>>();
        int num = Integer.parseInt(scan.nextLine());

        while (scan.hasNextLine() && dataMap.size() <= num) {
            String str = scan.nextLine();
            String[] dataArr = str.split(" ");
            if (dataArr.length == 1) {
                break;
            }
            String outerKey = dataArr[0];
            Integer innerKey = Integer.parseInt(dataArr[2]);
            Integer innerVal = Integer.parseInt(dataArr[1]);
            if (dataMap.containsKey(outerKey)) {
                SortedMap<Integer, Integer> innerMap = dataMap.get(outerKey);
                innerMap.put(innerKey, innerVal);
                dataMap.put(outerKey, innerMap);
            } else {
                SortedMap<Integer, Integer> innerMap = new TreeMap<Integer, Integer>();
                innerMap.put(innerKey, innerVal);
                dataMap.put(outerKey, innerMap);
            }
        }

        for (String key : dataMap.keySet()) {
            SortedMap<Integer, Integer> innerMap = dataMap.get(key);
            for (Integer innerDataKey : innerMap.keySet()) {
                System.out.println(key + " " + innerMap.get(innerDataKey) + " " + innerDataKey + " ");
            }
        }
    }
}
