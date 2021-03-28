package math.easy;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 */

class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int len = columnTitle.length();
        for (int i = 0; i < len; i++) {
            sum +=((int)(columnTitle.charAt(len-i-1)-'A')+1) * Math.pow(26,i);
        }
        return sum;
    }
}

public class Question171 {
    
}
