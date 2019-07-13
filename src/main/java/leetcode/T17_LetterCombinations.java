package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Songxc
 * @Date: 1:01 2019/7/14
 * @Description: 电话号码的字母组合
 *  思路：
 *   回溯法， 时间复杂度 0(3^n * 4^m). 空间复杂度 0(3^n * 4^m)
 */
public class T17_LetterCombinations {
    private Map<String, String> phoneMap = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backTrace("", digits);
        }
        return output;
    }

    public void backTrace(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phoneMap.get(digit).substring(i, i + 1);
                backTrace(combination + letter, nextDigits.substring(1));
            }
        }
    }

}
