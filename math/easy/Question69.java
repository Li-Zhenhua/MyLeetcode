package math.easy;

/**
 * 实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

 */

class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        int head = 0;int back = x;
        int mid = x/2;
        while(true){
            if((long)mid*mid < x){//注意这里要强制类型转换，数太大了！！！！数值溢出了
                head = mid;
                mid = head + (back - head)/2;
                if(mid == head) return mid;
            } else if((long)mid * mid > x){
                back = mid;
                mid = head + (back - head)/2;
                if(mid == back) return mid-1;
            }else{
                return mid;
            }
        }
    }
}

//牛顿迭代法
/*class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}*/


public class Question69 {
    
}
