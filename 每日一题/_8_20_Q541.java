package 每日一题;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */

class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < n){
            if(index + 2*k <= n){
                for (int i = k-1; i >= 0; i--) {
                    sb.append(s.charAt(index+i));
                }
                sb.append(s.substring(index+k, index+2*k));
            } else if(index + k <= n){
                for (int i = k-1; i >= 0; i--) {
                    sb.append(s.charAt(index+i));
                }
                sb.append(s.substring(index+k, n));
            }else{
                for (int i = n-1; i >= index; i--) {
                    sb.append(s.charAt(i));
                }
            }
            index += 2*k;
        }
        return sb.toString();
    }
}

public class _8_20_Q541 {
    
}
