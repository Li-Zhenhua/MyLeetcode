package math.easy;


/**给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。

*/

//自己写的复杂的一批orz
class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        String sx = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        if(sx.charAt(0) == '-'){
            sb.append(sx.substring(1));
            sb.append('-').reverse();
        } else{
            sb.append(sx).reverse();
        }
        int k = 0;
        if(sb.charAt(0) == '-') k = 1;
        while(k < sb.length()){
            if(sb.charAt(k) == 0)
                sb.deleteCharAt(k);
            k++;
        }
        int maxNum = (int) Math.pow(2, 31)-1;
        int minNum = (int) Math.pow(-2, 31);
        String maxNumString = String.valueOf(maxNum);
        String minNumString = String.valueOf(minNum);
        k=0;
        if((sb.charAt(0)!='-'&& sb.length() == maxNumString.length()) || sb.length() == minNumString.length()){
            while(k<sb.length()){
                if(sb.charAt(0) == '-'){
                    if(sb.charAt(k)<minNumString.charAt(k)) break;
                    else if(sb.charAt(k)>minNumString.charAt(k)){
                        return 0;
                    }
                }else {
                    if(sb.charAt(k)<maxNumString.charAt(k)) break;
                    else if(sb.charAt(k)>maxNumString.charAt(k)){
                        return 0;
                    }
                }
                k++;
            }
        }
        
        return Integer.parseInt(sb.toString());
        
    }
}

//官方方法，模10取余！！
/*class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;//4字节int类型范围-2147483648~2147483647
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}*/


public class Question7 {
    
}
