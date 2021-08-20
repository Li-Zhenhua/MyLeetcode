package 每日一题;

import java.util.Arrays;

/**
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
'A'：Absent，缺勤
'L'：Late，迟到
'P'：Present，到场
如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：

按 总出勤 计，学生缺勤（'A'）严格 少于两天。
学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。

 */

 
//好烦啊，知道是动规但是老是想不明白转移方程
//定义 dp[i][j][k] 表示前 i 天有 j 个 ‘A’ 且结尾有连续 k 个 ‘L’ 的可奖励的出勤记录的数量

//状态转移：所有的状态都是从前一天，即 i-1，转移而来，但是对于 j 和 k，要分三种情况来讨论：
//当前填入的是 P，i-1 天的任何状态都能转移过来；
//当前填入的是 A，i-1 天即之前肯定没填过 A，同时所有的 late 状态都可以转移到过来。
//当前填入的是 L，i-1 天最多只能有一个连续的 L，其他的状态依次转移过来。

//注意到 dp[i][][] 只会从 dp[i−1][][] 转移得到。因此可以将 dp 中的总天数的维度省略
/*class Solution {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] dp = new int[n+1][2][3];
        dp[0][0][0] = 1; //边界条件
        for (int i = 1; i <= n; i++) {
            //第i天为P时,结尾不存在连续的L
            //注意这里dp[i-1][0][0] + dp[i-1][0][1]这样的都可能超过范围了，所以要先mod
            dp[i][0][0] = ((dp[i-1][0][0] + dp[i-1][0][1]) % MOD + dp[i-1][0][2]) % MOD;
            dp[i][1][0] = ((dp[i-1][1][0] + dp[i-1][1][1]) % MOD + dp[i-1][1][2]) % MOD;

            //第i天为A时,结尾不存在连续的L,且前面不能出现过A
            //注意前面出现过dp[i][1][0]，要合并
            //dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]) % MOD;
            for(int j = 0; j < 3; j++){
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][j]) % MOD;
            }

            //第i天为L时,前面只能出现0次或1次L,因为没有加法所以可以不用mod
            dp[i][0][1] = dp[i-1][0][0];
            dp[i][0][2] = dp[i-1][0][1];
            dp[i][1][1] = dp[i-1][1][0];
            dp[i][1][2] = dp[i-1][1][1];
        }

        int ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans += dp[n][i][j];
            }
        }
        return ans;
    }
}*/



//从上面可以看出，第i天只依赖于第i-1天，故这个维度可以优化
/*class Solution {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][] dp = new int[2][3];
        
        dp[0][0] = 1; //边界条件
        for (int i = 1; i <= n; i++) {
            int[][] newDp = new int[2][3];

            newDp[0][0] = ((dp[0][0] + dp[0][1]) % MOD + dp[0][2]) % MOD;
            for(int j = 0; j < 2; j++){
                for (int j2 = 0; j2 < 3; j2++) {
                    newDp[1][0] = (newDp[1][0] + dp[j][j2]) % MOD;
                }
            }
            newDp[0][1] = dp[0][0];
            newDp[0][2] = dp[0][1];
            newDp[1][1] = dp[1][0];
            newDp[1][2] = dp[1][1];

            dp = newDp;
        }

        int ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[i][j]) % MOD;
            }
        }
        return ans;
    }
}*/

//可以发现，上面状态转换只出现了六种情况，所以只需要六位的数组即可
//由于数组可以只需要两组进行重复使用，不需要每次都申请，故可以创建一个二维的6位数组
/*class Solution {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][] dp = new int[2][6];
        
        dp[0][0] = 1; //边界条件
        for (int i = 1; i <= n; i++) {
            //int[][] newDp = new int[2][3];
            int curr = i % 2;
            int pre = 1 - curr;
            dp[curr][0] = ((dp[pre][0] + dp[pre][1]) % MOD + dp[pre][2]) % MOD;
            dp[curr][3] = 0; //要置零
            for(int j = 0; j < 6; j++){
                dp[curr][3] = (dp[curr][3] + dp[pre][j]) % MOD;
            }
            dp[curr][1] = dp[pre][0];
            dp[curr][2] = dp[pre][1];
            dp[curr][4] = dp[pre][3];
            dp[curr][5] = dp[pre][4];
        }

        int ans = 0;
        int curr = n % 2;
        for (int i = 0; i < 6; i++) {
            ans = (ans + dp[curr][i]) % MOD;
        }
        return ans;
    }
}*/

//最好的做法，矩阵快速幂，根据六中状态的转移方程构造矩阵
class Solution {
    static final int MOD = 1000000007;

    public int checkRecord(int n) {
        long[][] mat = {{1, 1, 0, 1, 0, 0},
                        {1, 0, 1, 1, 0, 0},
                        {1, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 1, 0},
                        {0, 0, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0}};
        long[][] res = pow(mat, n);
        long sum = Arrays.stream(res[0]).sum();
        return (int) (sum % MOD);
    }

    public long[][] pow(long[][] mat, int n) {
        long[][] ret = {{1, 0, 0, 0, 0, 0}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, mat);
            }
            n >>= 1;
            mat = multiply(mat, mat);
        }
        return ret;
    }

    public long[][] multiply(long[][] a, long[][] b) {
        int rows = a.length, columns = b[0].length, temp = b.length;
        long[][] c = new long[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < temp; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    c[i][j] %= MOD;
                }
            }
        }
        return c;
    }
}

public class _8_18_Q552 {
    
}
