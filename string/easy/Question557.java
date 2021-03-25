package string.easy;

import java.util.Stack;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，
 * 同时仍保留空格和单词的初始顺序。
 */

 //有点慢
/*class Solution {
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if(i == s.length()-1){
                sb.append(s.charAt(i));
                while(!stack.isEmpty())
                    sb.append(stack.pop());
            }
            
            if(s.charAt(i) == ' '){
                while(!stack.isEmpty())
                    sb.append(stack.pop());
                sb.append(' ');
            }else{
                stack.push(s.charAt(i));
            }
        }
        return sb.toString();
    }
}*/

 //不用栈，快一点的方法，但还是15ms
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int head = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                for (int j = i-1; j >= head; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append(' ');
                head = i+1;
            }
            if(i == s.length() - 1){
                for (int j = i; j >= head; j--) {
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}

//别人的答案，3ms，用数组做而不是stringbuilder
/*class Solution {
    public String reverseWords(String s) {
        char[] cr = s.toCharArray();
        int i = 0;
        int j = 0;
        while(i < cr.length){
            //开始位置
            int l = i;
            //结束位置
            int r = i - 1;
            for(j = i;j < cr.length;j++){
                if(cr[j] == ' '){
                    break;
                }
                //更新结束位置
                r++;
            }
            //更新开始指针
            i = j + 1;
            //原数组上替换
            while(l < r){
                char tmp = cr[l];
                cr[l++] = cr[r];
                cr[r--] = tmp;
            }
        }
        return new String(cr);
    }
}*/

public class Question557 {
    
}
