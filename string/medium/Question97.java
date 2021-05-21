package string.medium;

/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。

两个字符串 s 和 t 交错 的定义与过程如下，
其中每个字符串都会被分割成若干 非空 子字符串：

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 
或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
提示：a + b 意味着字符串 a 和 b 连接。
 */

 //递归超时了，故应该是用动态规划解的
/*class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(("".equals(s1) && s2.equals(s3)) || ("".equals(s2) && s1.equals(s3))) return true;
        if("".equals(s1) || "".equals(s2)) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3) return false;
        
        return find(s1, s2, s3, 0, 0, 0);


    }

    public boolean find(String s1, String s2, String s3, int index1, int index2, int index3){
        if(index3 == s3.length()) return true;

        if(index1 == s1.length()){
            if(s3.charAt(index3) == s2.charAt(index2)){
                if(find(s1, s2, s3, index1, index2+1, index3+1)) return true;
                //return false;
            }
            return false;
        }else if(index2 == s2.length()){
            if(s3.charAt(index3) == s1.charAt(index1)){
                if(find(s1, s2, s3, index1+1, index2, index3+1)) return true;
                //return false;
            }
            return false;
        }
        
        // int len1 = s1.length();
        // int len2 = s2.length();
        // int len3 = s3.length();
        if(s3.charAt(index3) == s1.charAt(index1) && s3.charAt(index3) == s2.charAt(index2)){
            if(find(s1, s2, s3, index1+1, index2, index3+1)) return true;
            if(find(s1, s2, s3, index1, index2+1, index3+1)) return true;
            return false;
        }

        if(s3.charAt(index3) == s1.charAt(index1)){
            if(find(s1, s2, s3, index1+1, index2, index3+1)) return true;
            return false;
        }

        if(s3.charAt(index3) == s2.charAt(index2)){
            if(find(s1, s2, s3, index1, index2+1, index3+1)) return true;
            return false;
        }

        return false;
    }
}*/

//转移方程没想到orz
//就类似路径问题，只能向右或向下
//dp[i][j]表示s1的前i个元素和s2的前j个元素能否交错组成s3的前i+j个元素
class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3){
            return false;
        }

        /*boolean[][] dp = new boolean[len1+1][len2+1];
        //初始空值时为true
        dp[0][0] = true;
        for (int i = 0; i < len1+1; i++) {
            for (int j = 0; j < len2+1; j++) {
                if(i > 0){
                    dp[i][j] = dp[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1);
                }

                //往右方查的时候能找到对的时就不用往下方找了
                if(dp[i][j]) continue;

                if(j > 0){
                    dp[i][j] =dp[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1);
                }
            }
        }
        return dp[len1][len2];*/

        //优化空间复杂度,按行来
        boolean[] dp = new boolean[len2+1];
        dp[0] = true;
        int index = 1;
        while(index <= len2){
            //此时行数i为0，列数j即为index
            dp[index] = dp[index-1] && s3.charAt(index-1) == s2.charAt(index-1);
            index++;
        }
        //循环行
        for (int i = 1; i < len1+1; i++) {
            dp[0] = dp[0] && s3.charAt(i-1) == s1.charAt(i-1);
            index = 1;
            while(index <= len2){
                dp[index] = (dp[index] && s3.charAt(i+index-1) == s1.charAt(i-1)) || (dp[index-1] && s3.charAt(i+index-1) == s2.charAt(index-1));
                index++;
            }
        }
        return dp[len2];
    }
}

public class Question97 {
    public static void main(String[] args) {
        Solution97 s = new Solution97();
        s.isInterleave("aa", "bb", "aabc");
    }
}
