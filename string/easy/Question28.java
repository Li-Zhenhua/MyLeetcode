package string.easy;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 */
//就是实现indexOf方法

class Solution {
    /*public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;//注意不能用==，尽量除了基本类型外都用equals
        int index = -1;
        for (int i = 0; i < haystack.length() - needle.length()+1; i++) {
            if(needle.charAt(0) != haystack.charAt(i)) continue;
            index = 1;
            for (; index < needle.length(); index++) {
                if(haystack.charAt(i+index) != needle.charAt(index)){
                    break;
                }
            }
            if(index == needle.length()){
                return i;
            } else {
                index = -1;
            }
        }
        return index;
    }*/

    //简洁点
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) return 0;
        int m = haystack.length(), n = needle.length();
        int index;
        for (int i = 0; i < m - n + 1; i++) {
            for (index = 0 ; index < n; index++) {
                if (haystack.charAt(i + index) != needle.charAt(index)) break;
            }
            if (index == n) return i;  
        }       
        return -1;
    }
}





public class Question28 {
    
}
