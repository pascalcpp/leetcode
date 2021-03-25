package com.xpcf.algorithm;

import java.util.HashSet;
import java.util.Hashtable;
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
            char[] charArray = s.toCharArray();
            int length = s.length();
            int index = 0;
            int curMaxLength, curStart, curEnd, endLength;
            curMaxLength = curStart = curEnd = 0;
            if (s == null || s.length() == 0) {
                return 0;
            }

            HashSet<Object> set = new HashSet<>();

            while (index < length) {
                char ch = charArray[index];
                if (!set.contains(ch)) {
                    set.add(ch);
                    curEnd = index;
                } else {

                    if (curEnd - curStart > curMaxLength - 1) {
                        curMaxLength = curEnd - curStart + 1;
                    }

                    index = curEnd;
                    set.remove(charArray[curStart]);
                    ++curStart;
                }

                ++index;
            }




            endLength = curEnd - curStart + 1;

            return curMaxLength < endLength ? endLength : curMaxLength;
        }
    }
}
