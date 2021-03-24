package string.easy;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。

「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 */

class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";

        String s = countAndSay(n-1);
        //String temp = "";字符串是不可变的！！！
        StringBuilder temp = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if(i != s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                count++;
            } else{
                temp.append(String.valueOf(count));
                temp.append(s.charAt(i));
                count = 1;
            }
        }
        return temp.toString();
    }
}

public class Question38 {
    
}
