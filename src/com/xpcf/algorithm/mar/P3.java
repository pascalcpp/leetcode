package com.xpcf.algorithm.mar;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 执行用时：
 * 8 ms
 * , 在所有 Java 提交中击败了
 * 54.93%
 * 的用户
 * 内存消耗：
 * 38.9 MB
 * , 在所有 Java 提交中击败了
 * 22.50%
 * 的用户
 * @author XPCF
 * @version 1.0
 * @date 3/26/2021 2:12 AM
 */
public class P3 {
    public static void main(String[] args) {

        System.out.println(new P3().new Solution().lengthOfLongestSubstring("aaaaa"));
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> occ = new HashSet<Character>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    occ.add(s.charAt(rk + 1));
                    ++rk;
                }
                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }
}
