package math.easy;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 */

 //用while很简单，下面是看到的精妙的O（1）方法
 //就是数学上的数根，数根与原数对9的模值一样
class Solution {
    public int addDigits(int num) {
        //基本原理x*100+y*10+z=x*99+y*9+x+y+z
        //但是如果原来的数就是9的倍数。此时会失效
        //故需要先减去一个1之后在加回来
        return (num - 1) % 9 + 1;
        
    }
}

public class Question258 {
    
}
