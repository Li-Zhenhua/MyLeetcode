package remaining200_gt.easy;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

 */

class Solution {
    public int longestPalindrome(String s) {
        //“A”的ASCII值为65，“a”的ASCII值为97,“z”的ASCII值为122
        int[] count = new int[122-65+1];
        int ans = 0;
        for(char c : s.toCharArray()){
            count[c-'A'] += 1; 
        }
        //出现偶数次的字符必然能全部用上，因为回文对称分布
        //奇数次的字符必然能用上n-1个（即最大的偶数个）
        //剩下的单个字符可以有一个作为最中间的字符
        for (int i : count) {
            ans += i%2 == 0 ? i : i-1;
        }

        return ans < s.length() ? ans+1 : ans;
    }
}

public class Question409 {
    
}
