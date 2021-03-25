package string.easy;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。
 */

class Solution {
    public String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            
            if(i < a.length()){
                sum += (a.charAt(a.length()-i-1)-'0');
            }
            if(i < b.length()){
                sum += (b.charAt(b.length()-i-1)-'0');
            }
            sb.append((char)(sum%2+'0'));//注意强制类型转换！
            sum /= 2;//这里相当于进位符号了
            
        } 
        if(sum == 1){
            sb.append('1');
        }
        return sb.reverse().toString();
    }    
}

public class Question67 {
    
}
