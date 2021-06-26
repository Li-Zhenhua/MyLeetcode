package remaining200_gt.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个含有数字和运算符的字符串，
 * 为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。
 * 有效的运算符号包含 +, - 以及 * 。
 */


 //分治思想
class Solution {
    Map<String,List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression){
        //默认测试集是不会出现空字符串的，所以可以不用判断
        /*if(expression.length() == 0){
            return new ArrayList<>();
        }*/

        //可以用一个map记录，防止可能出现重复字符串的时候的进行无用运算
        //这个优化很巧妙
        if(map.containsKey(expression)){
            return map.get(expression);
        }

        List<Integer> ans = new ArrayList<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1, n));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                            case '+':
                                ans.add(l+r);
                                break;
                            case '-':
                                ans.add(l-r);
                                break;
                            case '*':
                                ans.add(l*r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        //此时表示expression只有一个数字
        if(ans.size() == 0){
            ans.add(Integer.valueOf(expression));
        }

        //map记录
        map.put(expression, ans);

        return ans;
    }
}

public class Question241 {
    
}
