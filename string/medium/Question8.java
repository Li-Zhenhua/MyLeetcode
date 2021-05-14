package string.medium;

/**
 * 请你来实现一个 myAtoi(string s) 函数，
 * 使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 
 * 
函数 myAtoi(string s) 的算法如下：
* 读入字符串并丢弃无用的前导空格
* 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 
确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
* 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
字符串的其余部分将被忽略。
* 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
* 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，
使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，
大于 231 − 1 的整数应该被固定为 231 − 1 。
* 返回整数作为最终结果。

注意：
本题中的空白字符只包括空格字符 ' ' 。
除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 

 */

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        //其实有Character.isDigit(char)方法
        if(n == 0){
            return 0;
        }
        int beginChar = s.charAt(0);
        if((beginChar <'0' || beginChar > '9') && 
        (beginChar != '-' && beginChar != '+')){
            return 0;
        }
        int ans = 0;
        int sign = 1;
        int index = 0;
        if(beginChar == '-'){
            sign = -1;
            index++;
        }else if(beginChar == '+'){
            index++;
        }
        //从后往前得到字符串数字：除以10取余
        //从前往后构造字符串数字：原结果乘10加某一位数，迭代
        while(index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
            char c = s.charAt(index);
            if(ans > Integer.MAX_VALUE/10 || 
            (ans == Integer.MAX_VALUE/10 && c > '7')){ //MAX_VALUE = 2147483647
                return Integer.MAX_VALUE;
            }
            if(ans < Integer.MIN_VALUE/10 || 
            (ans == Integer.MIN_VALUE/10 && c == '9')){ //MIN_VALUE = -2147483648
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + (c-'0') * sign;
            index++;
        }
        return ans;
    }
}

public class Question8 {
    
}
