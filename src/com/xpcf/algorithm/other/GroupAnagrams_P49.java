package com.xpcf.algorithm.other;

import java.util.*;

/**
 * @author XPCF
 * @version 1.0
 * @date 6/2/2021 11:41 PM
 */
public class GroupAnagrams_P49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        for (List<String> value : map.values()) {
            ans.add(value);
        }
        return ans;

    }
}
