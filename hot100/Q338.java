package hot100;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
 * 计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 
 * 进阶:

给出时间复杂度为O(n*sizeof(integer))的解答非常容易。
但你可以在线性时间O(n)内用一趟扫描做到吗？
要求算法的空间复杂度为O(n)。
你能进一步完善解法吗？
要求在C++或任何其他语言中不使用任何内置函数
（如 C++ 中的 __builtin_popcount）来执行此操作。
 */

 //位运算
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            //当最后一位为1时，n中1的个数一定比前一个数n-1中1的个数多1
            if((i & 1) == 1){
                ans[i] = ans[i-1] + 1;
                continue;
            }
            int temp = i;
            int count = 0;
            //记录进了多少位
            while((temp & 1) == 0){
                temp >>= 1;
                count++;
            }
            ans[i] = ans[i-1]-count+1;
        }
        return ans;
    }
}

public class Q338 {
    
}
