package com.xpcf.algorithm.other;

import com.xpcf.algorithm.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/14/2021 5:16 PM
 */
public class ParseChemicalFormula {


    public static void main(String[] args) {
        ParseChemicalFormula t = new ParseChemicalFormula();
        t.removeParentheses("HMg2(H2(O2N3)3)3N2");
        System.out.println(t.sb.toString());
        t.parseFormula();
        System.out.println();
    }

    private Map<String, Integer> map = new HashMap<>();
    private int index = 0;
    private int len = 0;
    private int basic = 1;
    private StringBuilder sb;

    public void parseFormula() {
        index = 0;
        len = sb.length();
        char ch;
        while (index < len) {
            ch = sb.charAt(index);

            if (Character.isUpperCase(ch)) {
                StringBuilder builder = new StringBuilder();
                int num = 1;
                builder.append(ch);

                if (Character.isLowerCase(ch = sb.charAt(++index))) {
                    builder.append(ch);
                } else {
                    --index;
                }
                String chemical = builder.toString();
                builder.replace(0, builder.length(), "");
                while (++index < len && Character.isDigit(ch = sb.charAt(index))) {
                    builder.append(ch);
                }
                if (builder.length() > 0) {
                    num = Integer.parseInt(builder.toString());
                }


                if (map.containsKey(chemical)) {
                    map.put(chemical, map.get(chemical) + num);
                } else {
                    map.put(chemical, num);
                }
            } else {
                ++index;
            }
        }
    }

    public void removeParentheses(String s) {
        sb = new StringBuilder(s);
        len = s.length();
        index = len - 1;
        char ch;
        while (index > -1) {
            ch = sb.charAt(index);
            if (Character.isDigit(ch)) {
                basic = Character.getNumericValue(ch);
            } else if (ch == ')') {
                // eat digit and )
                if (index + 1 < len && Character.isDigit(sb.charAt(index + 1))) {
                    sb.replace(index, index + 2, "");
                }
                parseParentheses();
                basic = 1;
            }
            --index;


        }

    }

    public void parseParentheses() {

        int curV = 0;
        char ch;

        while (--index > -1 && (ch = sb.charAt(index)) != '(') {
            if (ch == ')') {
                if (index + 1 < len && Character.isDigit(sb.charAt(index + 1))) {
                    sb.replace(index, index + 2, "");
                }
                basic = curV;
                parseParentheses();
                basic = curV;
            } else if (Character.isDigit(ch)) {
                curV = basic * Character.getNumericValue(ch);
                sb.replace(index, index + 1, Integer.toString(curV));
            }
        }
        // eat (

        sb.replace(index, index + 1, "");
    }

}
