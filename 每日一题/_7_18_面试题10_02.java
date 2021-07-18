package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。

注意：本题相对原题稍作修改
 */

 //对每个字符串的字符数组排序，hashmap记录
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] sChar = s.toCharArray();
            Arrays.sort(sChar);
            String temp = String.valueOf(sChar);
            if(map.containsKey(temp)){
                map.get(temp).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(temp,list);
            }
        }

        for(String s : map.keySet()){
            ans.add(map.get(s));
        }

        return ans;
    }
}

public class _7_18_面试题10_02 {
    
}
