package string.medium;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

'A' -> 1
'B' -> 2
...
'Z' -> 26
要 解码 已编码的消息，所有数字必须基于上述映射的方法，
反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：

"AAJF" ，将消息分组为 (1 1 10 6)
"KJF" ，将消息分组为 (11 10 6)
注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，
这是由于 "6" 和 "06" 在映射中并不等价。

给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。

题目数据保证答案肯定是一个 32 位 的整数。
 */

 //递归不行那就动态规划了
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        //return find(s, 0);
        int n = s.length();
        //两个指针分别指向下一个和下下一个
        //因为以当前curr指向的数开头的后续数的组合总个数
        //等于以下一个数开头和下下一个数开头的组合总数之和
        //不过要判断是否需要下下一个数的情况
        int numNext2 = 1;
        int numNext1 = s.charAt(n-1) == '0' ? 0 : 1;
        int curr = n-2;
        while(curr >= 0){
            char c = s.charAt(curr);
            if(c == '0'){
                numNext2 = numNext1;
                numNext1 = 0;
            }else if(c == '1'){
                int temp = numNext1 + numNext2;
                numNext2 = numNext1;
                numNext1 = temp;
            }else if(c == '2'){
                if(s.charAt(curr+1) > '6'){
                    numNext2 = numNext1;
                    // numNext1 = numNext1;
                }else{
                    int temp = numNext1 + numNext2;
                    numNext2 = numNext1;
                    numNext1 = temp;
                }
            }else{
                numNext2 = numNext1;
            }
            curr--;
        }
        return numNext1;
    }

    /*public int find(String s, int index){
        if(index == s.length()) return 1;
        if(index == s.length()-1){
            if(s.charAt(index) == '0') return 0;
            else return 1;
        }
        
        if(s.charAt(index) > '2'){
            return find(s,index+1);
        }else if(s.charAt(index) == '2'){
            if(s.charAt(index+1) > '6'){
                return find(s, index+1);
            }else{
                return find(s, index+1) + find(s, index+2);
            }
        }else if(s.charAt(index) == '1'){
            return find(s, index+1) + find(s, index+2);
        }else{
            return 0;
        }
        
    }*/
}

public class Question91 {
    
}
