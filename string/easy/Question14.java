package string.easy;


/**
 * 
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。
 */

 //暴力解法效率奇低，一时间想不到其他解法orz
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String ans = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if(strs[j].length() <=i || strs[0].charAt(i)!=strs[j].charAt(i)){
                    return ans;
                }
            }
            ans = ans + strs[0].charAt(i);
        }
        return ans;
    }
}

//分治解法
/*class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());       
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }
}*/


public class Question14 {
    
}
