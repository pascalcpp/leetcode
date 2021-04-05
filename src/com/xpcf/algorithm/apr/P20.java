package com.xpcf.algorithm.apr;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/5/2021 11:17 AM
 */
public class P20 {

    public static void main(String[] args) {
        P20 p = new P20();
        System.out.println(p.isValid("[[[]"));
    }
    int cur = 0;
    int len;



    public boolean isValid(String s) {


        len = s.length();
        while (cur < len) {
            if (!parseValue(s)) {
                return false;
            }
        }
        return true;
    }

    public boolean parseValue(String s) {

        if (cur + 1 >= len) {
            return false;
        }
        switch (s.charAt(cur)) {
            case '(':
                return parseAngle(s);
            case '[':
                return parseMid(s);
            case '{':
                return parseCurly(s);
        }
        return false;
    }

    public boolean parseAngle(String s) {

        if (s.charAt(++cur) == ')') {
            ++cur;
            return true;
        } else {

            while (s.charAt(cur) != ')') {
                if (!parseValue(s)) {
                    return false;
                }
                if (cur >= len) {
                    return false;
                }
            }
            ++cur;
            return true;
        }

    }

    public boolean parseMid(String s) {

        if (s.charAt(++cur) == ']') {
            ++cur;
            return true;
        } else {

            while (s.charAt(cur) != ']') {
                if (!parseValue(s)) {
                    return false;
                }
                if (cur >= len) {
                    return false;
                }
            }
            ++cur;
            return true;

        }


    }

    public boolean parseCurly(String s) {

        if (s.charAt(++cur) == '}') {
            ++cur;
            return true;
        } else {


            while (s.charAt(cur) != '}') {
                if (!parseValue(s)) {
                    return false;
                }
                if (cur >= len) {
                    return false;
                }
            }
            ++cur;
            return true;

        }
    }
}
