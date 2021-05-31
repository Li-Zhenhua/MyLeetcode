package remaining200_gt.easy;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。
 * 如果是，返回 true ；否则，返回 false 。

整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 */

class Solution {
    public boolean isPowerOfFour(int n) {
        //第二个条件是判断二进制中有几位1，如果有大于一个的1，那一定不是4的幂
        if(n <= 0 || ((n-1)&n) != 0) return false;
        boolean flag = true;
        //0、2、4等偶数位是1则是4的幂
        while((n&1) == 0){
            n = n>>1;
            flag = !flag;
        }
        return flag;
    }
}

public class Question342 {
    
}
