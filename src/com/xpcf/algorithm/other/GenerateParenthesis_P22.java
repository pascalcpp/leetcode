package com.xpcf.algorithm.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XPCF
 * @version 1.0
 * @date 5/20/2021 7:09 PM
 */
public class GenerateParenthesis_P22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == n << 1) {
            ans.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtrack(ans, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            backtrack(ans, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


}
