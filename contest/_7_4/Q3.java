package contest._7_4;

//别人的方法，好像是种算法思路来着？
//查了一下，叫快速幂算法orz，感觉听过又忘了
class Solution {
    public int countGoodNumbers(long n) {
        long mod = (long) (1e9+7);
        long half = n/2;
        long odd = pow(4,half,mod);
        long even = pow(5,half,mod);
        if(n%2==1){
            even = even * 5 % mod;
        }
        return (int) (odd * even % mod);
    }
    //n为底数，每高一位，底数就是相当于自乘一次
    public long pow(long n,long x,long mod){
        long res = 1;
        while (x>0){
            if((x&1)==1)res = res * n % mod;
            n = n * n % mod;
            x>>=1;
        }
        return res;
    }
}

/*class Solution {
    public int countGoodNumbers(long n) {
        //突然想到分治,好像也不对
        if(n == 1) return 5;
        if(n == 2) return 20;
        long left = n/2;
        long right = n-left;
        long ans = countGoodNumbers(left)*countGoodNumbers(right);
        ans = ans % 1000000007;
        return (int) ans;

        //超时了orz
        // long odd = n/2;
        // long even = n- n/2;
        // long ans = 1;
        // long factor = 1;
        // if(even != odd){
        //     ans *= 5;
        //     ans = ans % (1000000007);
        // }
        // while(odd % 2 == 0){
        //     factor *= 20;
        //     odd = odd/2;
        // }
        // for (long i = 0; i < odd; i++) {
        //     //ans <<= 2;  //乘4
        //     ans *= 20*factor;
        //     ans = ans % (1000000007);
            
        // }
        // // for (long i = 0; i < even; i++) {
        // //     ans *= 5;
        // //     ans = ans % (1000000007);
        // // }
        
        // return (int) ans;

    }   
}*/

public class Q3 {
    
}
