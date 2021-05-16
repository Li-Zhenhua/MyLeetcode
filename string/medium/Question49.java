package string.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。
 * 字母异位词指字母相同，但排列不同的字符串。
 */

 //想到了好像又没想明白orz，原来是用一个map记录每一个出现过的组合的列表
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        //List<String> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            String s = String.valueOf(charArray);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(string);
            map.put(s, list);
        }
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}

//另一种做法，用计数办法
/*class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}*/

public class Question49 {
    
}
