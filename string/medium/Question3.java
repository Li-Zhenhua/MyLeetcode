package string.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int begin = 0, len = 1;
        for (int i = 0; i < n; i++) {
            int index = map.getOrDefault(s.charAt(i), -1);
            //后面一个判断条件是防止形如“abba”这样的重复元素
            //等同于找到b重复之后得将a的map映射重置
            //其实前一个判断可以不要

            //看了别人的思路后，发现我自己的办法也算是滑动窗口变体哎
            if(/*index != -1 &&*/ index >= begin){
                len = Math.max(len, i - begin);
                begin = index+1;//新子串开始于重复元素的第一个之后
            }
            map.put(s.charAt(i), i);
        }
        //如果最后一位是一个新的字符，需要最后一次比较最大值
        len = Math.max(len, n-begin);
        return len;
    }
}

//滑动窗口法
/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
        
    }
}*/


public class Question3 {

}
