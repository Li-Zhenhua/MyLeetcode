package 每日一题;

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 */

class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0, base = 1;
        int n = columnTitle.length();
        for(int i = n-1; i >= 0; i--){
            char temp = columnTitle.charAt(i);
            ans += ((int) (temp - 'A') + 1) * base;
            base *= 26;
        }
        return ans;
    }
}

public class _7_30_Q171 {
    
}
