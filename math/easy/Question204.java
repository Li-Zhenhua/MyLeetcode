package math.easy;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 */

/*class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1 || n == 2) return 0;
        int[] memo = new int[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(memo[i] == 0){
                for (int j = i; j < n;) { //这里的质数开始位置可以是x*x，因为2*x，3*x必然已经在之前标记过了
                    memo[j] = 1;            //但是注意还要判断i*i是否溢出了
                    j = j + i;
                }
                count++;
            }
        }
        return count;
    }
}*/

class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n == 1 || n == 2) return 0;
        int[] memo = new int[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(memo[i] == 0){
                if((long) i*i < n){
                    for (int j = i*i; j < n;) { //这里的质数开始位置可以是x*x，因为2*x，3*x必然已经在之前标记过了
                        memo[j] = 1;            //但是注意还要判断i*i是否溢出了
                        j = j + i;
                    }
                } 
                count++;
            }
        }
        return count;
    }
}

public class Question204 {
    
}
