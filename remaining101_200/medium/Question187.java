package remaining101_200.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，
例如："ACGAATTCCG"。在研究 DNA 时，
识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来找出所有目标子串，目标子串的长度为 10，
且在 DNA 字符串 s 中出现次数超过一次。
 */

 //直接用一个集合
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if(n <= 10){
            return new ArrayList<>();
        }
        //记录出现过的长度为10的字符串
        Set<String> set = new HashSet<>();
        //记录已经加入到list的元素，去重
        Set<String> temp = new HashSet<>();
        for (int i = 0; i <= n-10; i++) {
            String s1 = s.substring(i, i+10);
            if(set.contains(s1)){
                temp.add(s1);
            }else{
                set.add(s1);
            }
        }
        return new ArrayList<>(temp);
    }
}

public class Question187 {
    
}
