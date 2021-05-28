package math.medium;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。
 * 将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，
例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

本题中，如果除法结果溢出，则返回 2^31 − 1
 */

 //果然超时了。。。。
/*class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend  == 0) return 0;
        //溢出时
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == Integer.MIN_VALUE) return 0;
        int count = 0;
        if(dividend > 0 && divisor > 0){
            while(dividend >= divisor){
                count++;
                dividend -= divisor;
            }
        }else if(dividend < 0 && divisor > 0){
            //防止取反溢出，所以不用-dividend
            while(dividend <= -divisor){
                count--;
                dividend += divisor;
            }
        }else if(dividend > 0 && divisor < 0){
            while(dividend >= -divisor){
                count--;
                dividend += divisor;
            }
        }else{
            while(dividend <= divisor){
                count++;
                dividend -= divisor;
            }
        }
        return count;
    }
}*/


//别人的详细写法过程
// 100/3
// 100>3 100>6 100>12 100>24 100>48 100>96 100<192 ---- 使用了 2^5 = 32 个3，还剩 100 - 96 = 4 需要被除
// 4>3 4<6                                         ---- 使用了 2^0 = 1  个3，还剩 4   - 3  = 1 需要被除
// 1<3                                             ---- 被除数小于除数，递归结束，总计使用了 33 个 3
/*class Solution {
    public int divide(int dividend, int divisor) {
        // 当除数为1，直接返回被除数
        if (divisor == 1) {
            return dividend;
        }
        // 当除数为-1且被除数为Integer.MIN_VALUE时，将会溢出，返回Integer.MAX_VALUE
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        // 把被除数与除数调整为正数,为防止被除数Integer.MIN_VALUE转换为正数会溢出，使用long类型保存参数
        if (dividend < 0 && divisor < 0) {
            return divide(-(long) dividend, -(long) divisor);
        } else if (dividend < 0 || divisor < 0) {
            return -divide(Math.abs((long) dividend), Math.abs((long) divisor));
        } else {
            return divide((long) dividend, (long) divisor);
        }
    }

    public int divide(long dividend, long divisor) {
        // 如果被除数小于除数，结果明显为0
        if (dividend < divisor) {
            return 0;
        }
        long sum = divisor; // 记录用了count个divisor的和
        int count = 1; // 使用了多少个divisor
        while (dividend >= sum) {
            // 每次翻倍
            sum <<= 1;
            count <<= 1;
        }

        // 此时dividend < sum
        sum >>>= 1;
        count >>>= 1;

        // 此时dividend >= sum
        // 将count个divisor从dividend消耗掉，剩下的还需要多少个divisor交由递归函数处理
        return count + divide(dividend - sum, divisor);
    }
}*/

//大致思路是，可以简单概括为： 60/8 = (60-32)/8 + 4 = (60-32-16)/8 + 2 + 4 = 1 + 2 + 4 = 7
//不用long的做法
class Solution {
    public int divide(int dividend, int divisor) { // 被除数 除数
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // 溢出
        int sign = 1;
        if((dividend > 0 && divisor < 0)||(dividend < 0 && divisor > 0))
            sign = -1;
       // if(divisor == 1) return dividend;
        // if(divisor == -1) return -dividend;
        int a = dividend>0 ? -dividend : dividend;
        int b = divisor>0 ? -divisor : divisor;
        // 都改为负号是因为int 的范围是[-2^31, 2^31-1]，如果a是-2^32，转为正数时将会溢出
        //System.out.println(a + " " + b);
        //if(a > b) return 0;
        int ans = div(a,b);
        return sign == -1 ? -ans : ans;
    }

    public int div(int a, int b){
        if(a > b) return 0;
        int count = 1;
        int tb = b;
        while(tb+tb >= a && tb+tb < 0){ // 溢出之后不再小于0
            tb += tb;
            count += count;
            //System.out.println(tb + " " + count + " " + count*b);
        }
        return count+div(a-tb,b);
    }
}

public class Question29 {
    
}
