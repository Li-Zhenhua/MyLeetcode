package string.easy;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。
 */

 //首位双指针
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0; int j = s.length()-1;
        while(i < j){
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                if((s.charAt(j)>='a' && s.charAt(j)<='z') || (s.charAt(j)>='0' && s.charAt(j)<='9')){
                    if(s.charAt(i) == s.charAt(j)){
                        i++;
                        j--;
                        continue;
                    } else {
                        return false;
                    }
                }else{
                    j--;
                }
            }else {
                i++;
            }   

        }
        return true;
    }
}

//官方解答，API调用
/*class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}*/



public class Question125 {

    
}
