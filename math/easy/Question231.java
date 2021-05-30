package math.easy;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */

/*class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n <= 0 ||n % 2 != 0) return false;
        while( n > 0){
            if( n == 1) return true;
            if( n % 2 != 0) return false;
            n /= 2;
        }
        return false;
    }
}*/

//位运算解法
//一个数 n 是 2 的幂，当且仅当 n 是正整数，并且 n 的二进制表示中仅包含 1 个 1。
//因此，如果 n 是正整数并且 n & (n - 1) = 0，那么 n 就是 2 的幂。
//n-1将低位的1之后的0全部变1，高位不受影响，例如n = 8，二进制为1000，n-1就是0111
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
public class Question231 {
    
}
