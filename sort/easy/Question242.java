package sort.easy;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        if(Arrays.equals(cs, ct)) return true;
        else return false;
    }
}

//用hash表法
/*class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[26];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }

    //更简单方法,聚合操作
    public boolean isAnagram4(String s, String t) {
        int[] counts = new int[26];
        //t.chars()返回一个字符流
        t.chars().forEach(tc -> counts[tc - 'a']++);
        s.chars().forEach(cs -> counts[cs - 'a']--);
        return Arrays.stream(counts).allMatch(c -> c == 0);
    }

    public boolean isAnagram(String s, String t) {
        return Arrays.equals(s.chars().sorted().toArray(), t.chars().sorted().toArray());
    }
}*/


public class Question242 {
    
}
