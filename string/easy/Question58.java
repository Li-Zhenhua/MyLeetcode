package string.easy;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。
 * 返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

 */

 //上来就想到split,完全没想到是要实现这个功能orz
/*class Solution {
    public int lengthOfLastWord(String s) {
        String[] sArray = s.split(" ");
        if (sArray.length == 0) return 0;
        return sArray[sArray.length-1].length();
    }
}*/

//第一次自己做的有这么高的效率，100.00,96.45！！！
class Solution {
    public int lengthOfLastWord(String s) {
        int back = s.length();
        boolean flag = false;
       for (int i = s.length()-1; i >=0 ; i--) {                   
            if(s.charAt(i) == ' '){
                if(flag == false){
                    back = i;
                    continue;
                } else {
                    return back - i-1;
                }   
            } else {
                flag = true;
                if( i == 0){
                    return back;
                }
            }         
       }
       return 0;
    }
}

public class Question58 {
    
}
