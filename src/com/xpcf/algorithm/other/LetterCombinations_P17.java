package com.xpcf.algorithm.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/19/2021 7:15 PM
 */
public class LetterCombinations_P17 {

    public static void main(String[] args) {
        String s = new String("");
        System.out.println("" == s);
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if ("".equals(digits)) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backTrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    private void backTrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder sb) {
        if (digits.length() == index) {
            combinations.add(sb.toString());
            return;
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int nextIndex = index + 1;
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                backTrack(combinations, phoneMap, digits, nextIndex, sb);
                sb.deleteCharAt(index);
            }
        }

    }

}
