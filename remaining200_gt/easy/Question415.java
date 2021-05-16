package remaining200_gt.easy;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 
 * 提示：

num1 和num2 的长度都小于 5100
num1 和num2 都只包含数字 0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */

 //竖式相加
class Solution {
    public String addStrings(String num1, String num2) {
        if("".equals(num1)) return num2;
        if("".equals(num2)) return num1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0){
            int numInt1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int numInt2 = j >= 0 ? num2.charAt(j) - '0': 0;
            int temp = numInt1 + numInt2 + carry;
            carry = temp / 10;
            temp = temp % 10;
            sb.append(temp);
            i--;
            j--;
        }
        
        if(carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

public class Question415 {
    
}
