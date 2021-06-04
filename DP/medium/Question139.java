package DP.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 
 *  s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 
 * 说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for (String word : wordDict) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        //dp[i]表示字符串s的前i个字符组合成的字符串是否可以分解成字典中的单词组合
        boolean[] dp = new boolean[s.length()+1];
        //逻辑上为了使得动态规划转移方程成立
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j >=0; j--) {
                
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
                //剪枝优化，只需要判断到set中最长的单词即可
                if(i - j > maxLen){
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

public class Question139 {
    
}
