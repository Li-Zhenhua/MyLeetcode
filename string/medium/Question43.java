package string.medium;

import java.util.ArrayList;
import java.util.List;

/**本题是415题升级版，415求加法
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

 */

 //依据竖式乘法
class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        
        if("0".equals(num1) || "0".equals(num2)) return "0";
        int carry = 0;
        int n1 = num1.length();int n2 = num2.length();
        //可以简单验算一下就知道两个数相乘后的位数不会超过两数位数之和
        int[] numArray = new int[n1+n2];
        for (int i = n1-1; i >= 0; i--) {
            int temp1 = num1.charAt(i)-'0';
            for (int j = n2-1; j >= 0; j--) {
                int temp2 = num2.charAt(j)-'0';
                int proSum = temp1 * temp2 + carry;
                carry = (numArray[i+j+1] + proSum) / 10;
                numArray[i+j+1] = (numArray[i+j+1] + proSum) % 10;
            }
            //这一步是为了防止这一轮的进位流向到下一轮的乘法中，影响结果
            //此时上述的j为0，故i+j+1的前一个i+j即为i
            if(carry > 0){
                numArray[i] = numArray[i] + carry;
                carry = 0;
            }
        }
        int index = 0;
        //若首位为0，即两数乘积的位数为n1+n2-1
        if(numArray[0] == 0) index = 1;

        for (; index < n1+n2; index++) {
            sb.append(numArray[index]);
        }
        return sb.toString();
    }
}

public class Question43 {
    
}
