package 每日一题;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */

 //元音字母a e i o u，注意有可能大写
 //吐了，竟然还可能有其他字符，如，.
class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length()-1;
        char[] cs = s.toCharArray();
        while(left < right){
            if(isVowels(cs[left]) && isVowels(cs[right])){
                exchagePosition(cs, left, right);
                left++;
                right--;
            }
            while(left < right && !isVowels(cs[left])){
                left++;
            }
            while(left < right && !isVowels(cs[right])){
                right--;
            } 
        }
        return String.valueOf(cs);
    }

    public boolean isVowels(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ;

    }

    public void exchagePosition(char[] cs, int left, int right){
        char temp = cs[left];
        cs[left] = cs[right];
        cs[right] = temp;
    }
}

public class _8_19_Q345 {
    
}
