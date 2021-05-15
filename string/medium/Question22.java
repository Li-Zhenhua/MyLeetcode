package string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，
 * 用于能够生成所有可能的并且 有效的 括号组合。
 */

class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    private char leftBraket = '(';
    private char rightBraket = ')';
    public List<String> generateParenthesis(int n) {
        braketsCombination(n,n);
        return ans;
    }

    public void braketsCombination(int countLeft, int countRight){
        //要有效，必须左括号个数时刻不少于右括号个数
        if(countLeft > countRight) return;
        
        if(countLeft == 0){
            if(countRight == 0){
                ans.add(sb.toString());
            }else{
                sb.append(rightBraket);
                braketsCombination(countLeft, countRight-1);
                sb.deleteCharAt(sb.length()-1);
            } 
            return;
        }

        sb.append(leftBraket);
        braketsCombination(countLeft-1, countRight);
        sb.deleteCharAt(sb.length()-1);

        sb.append(rightBraket);
        braketsCombination(countLeft, countRight-1);
        sb.deleteCharAt(sb.length()-1);
    }
}

public class Question22 {
    
}
