package string.medium;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）
 */

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        //记录各个字母出现的次数，这一步挺重要的，刚开始没想到
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }

        //记录相应字母是否已经使用过
        boolean[] flag = new boolean[26];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!flag[c-'a']){
                while(sb.length() > 0 && sb.charAt(sb.length()-1) > c){
                    if(count[sb.charAt(sb.length()-1)-'a'] > 0){
                        flag[sb.charAt(sb.length()-1)-'a'] = false;
                        sb.deleteCharAt(sb.length()-1);
                        continue;
                    }
                    break;
                }
                sb.append(c);
                count[c-'a']--;
                flag[c-'a'] = true;
            }else{
                //必须得将相应字母的计数减一
                count[c-'a']--;
            }
        }
        return sb.toString();
    }
}

public class Question316 {
    
}
