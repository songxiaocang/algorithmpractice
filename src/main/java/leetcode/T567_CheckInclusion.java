package leetcode;

import java.util.*;

/**
 * @Author: Songxc
 * @Date: 17:39 2020/4/2
 * @Description:
 *  给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 思路：
 *  滑动窗口
 *
 *  维护一个 count 变量，该变量存储字符数（26个字母表中的数字），这些字符在 s1 中具有
 *  相同的出现频率，当前窗口在 s2 中。当我们滑动窗口时，如果扣除最后一个元素并添加新元素导致任何
 *  字符的新频率匹配，我们将 count 递增1.如果不是，我们保持 count完整。但是，
 *  如果添加频率相同的字符（添加和删除之前）相同的字符，现在会导致频率不匹配，这会通过递减相同的 count
 * 变量来考虑。如果在移动窗口后，count 的计算结果为26，则表示所有字符的频率完全匹配。所以，
 * 我们立即返回一个True。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T567_CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;

        }
        return count == 26;
    }

    //查找index 无重复元素
    public static int findindex(char[] arr,String s){
        if(arr.length>s.length())
            return -1;
        Set<Character> sets=new HashSet<>();
        Set<Character> curWindow=new HashSet<>();
        int curStart=0;
        for(char c:arr) sets.add(c);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(sets.contains(c)&&!curWindow.contains(c)){
                curWindow.add(c);
                if(curWindow.size()==arr.length)
                    return curStart;
            }else if(sets.contains(c)&&curWindow.contains(c)){
                while(s.charAt(curStart)!=c){
                    curWindow.remove(s.charAt(curStart));
                    curStart++;
                }
                curStart++;

            }else{
                curStart=i+1;
                curWindow.clear();
            }

        }
        return -1;
    }

    //查找index 有重复元素
    public static int findindexForList(char[] arr,String s){
        if(arr.length>s.length())
            return -1;
        List<Character> list=new ArrayList<>();
        List<Character> curWindow=new ArrayList<>();
        int curStart=0;
        for(char c:arr) list.add(c);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(list.contains(c)){
                curWindow.add(c);
                Iterator<Character> iterator = list.iterator();
                int deleteCount = 0;
                while (iterator.hasNext()) {
                    char partStr = iterator.next();
                    if (partStr == c && deleteCount == 0) {
                        deleteCount++;
                        iterator.remove();
                    }
                }
                if(curWindow.size()==arr.length)
                    return curStart;
            }else{
                list.clear();
                for (char a : arr) {
                    list.add(a);
                }
                curStart=i+1;
                curWindow.clear();
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        boolean result = checkInclusion("ab", "eidbaooo");
        System.out.println(result);
        System.out.println("-----------");
        int index = findindexForList(new char[]{'a', 'b'}, "eidbaooo");
        int index2 = findindex(new char[]{'a', 'b', 'c', 'd'}, "tbcacbdata");
        int index3 = findindexForList(new char[]{'a', 'd', 'a', 't'}, "tbcacbdata");
        System.out.println(index);
        System.out.println(index2);
        System.out.println(index3);

    }

}
