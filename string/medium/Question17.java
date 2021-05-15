package string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 */

 //正常回溯就完事，但是这个map的构造方法记一记
class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    //学到了，可以这么初始化
    //注意第二个大括号意味着代码块
    Map<Character,String> map = new HashMap<>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0) return ans;
        numCombination(digits, 0);
        return ans;
    }

    public void numCombination(String digits, int index){
        if(index == digits.length()){
            ans.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            numCombination(digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

public class Question17 {
    
}
