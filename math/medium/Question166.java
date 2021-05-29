package math.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，
 * 以 字符串形式返回小数 。

如果小数部分为循环小数，则将循环的部分括在括号内。

如果存在多个答案，只需返回 任意一个 。

对于所有给定的输入，保证 答案字符串的长度小于 104 。
 */

 //自己写的方法还有很多细节问题，看看官方答案
/*class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        if(denominator == 1) return String.valueOf(numerator);
        if(numerator == Integer.MIN_VALUE && denominator == -1) return "2147483648";//防止溢出
        StringBuilder sb = new StringBuilder();
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)){
            sb.append('-');
        }
        //原来内存溢出的原因在这，要把两数转换成long
        // numerator = Math.abs(numerator);
        // denominator = Math.abs(denominator);
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        long intPart = dividend / divisor;
        long decPart = dividend % divisor;
        sb.append(intPart);
        if(decPart == 0) return sb.toString();
        sb.append(".");
        

        StringBuilder sb2 = new StringBuilder();
        //用map吧
        long[] flag = new long[divisor];//记录首次出现某个余数的位置
        long temp = decPart;
        // sb2.append(temp / denominator);
        // temp = temp % denominator;
        int count = 1;
        while(temp != 0 && flag[temp-1] == 0){
            flag[temp-1] = count;
            count++;
            temp = temp * 10;
            int intTemp = temp / denominator;
            sb2.append(intTemp);
            temp = temp % denominator;
        }
        if(temp == 0){
            sb.append(sb2);
            return sb.toString();
        }

        //if(flag[temp-1] != 0){
        count = 1;
        int n = flag[temp-1];
        while(count < n){
            sb.append(sb2.charAt(count-1));
            count++;
        }
        sb.append('(');
        sb.append(sb2.substring(count-1));
        sb.append(')');
        return sb.toString();
        //}
    }
}*/

//官方答案，注意很多细节
class Solution{
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) { //异或
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");//竟然还有insert方法
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}

public class Question166 {
    
}
