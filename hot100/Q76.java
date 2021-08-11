package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 
 * 注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */

//滑动窗口，刚开始没反应过来，看了一下就有点思路了
class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if(sLen < tLen) return "";
        //其实对于英文字符来说，直接开辟一个128数组就完事，可以不用map
        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }
        int left =0, right = 0;
        int findChars = 0;
        int minLen = Integer.MAX_VALUE, start = 0;
        while(right < sLen){
            char c2 = s.charAt(right);
            if(!tMap.containsKey(c2)){
                right++;
                continue;
            }

            int sTemp = sMap.getOrDefault(c2,0);
            //也就是当要找的字符数多于需求时，就不计入
            if(sTemp < tMap.get(c2)){
                findChars++;
            }
            sMap.put(c2, sTemp+1);
            while(findChars == tLen){
                char c3 = s.charAt(left);
                if(!tMap.containsKey(c3)){
                    left++;
                    continue;
                }
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }
                int sTemp2 = sMap.getOrDefault(c3,0);
                if(sTemp2 == tMap.get(c3)){
                    findChars--;
                }
                sMap.put(c3, sTemp2-1);
                left++;
            }

            right++;
        }

        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, start+minLen);
    }

    
}

public class Q76 {
    
}
