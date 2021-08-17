package hot100;


//求汉明距离
class Solution {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        ans = x ^ y;
        ans = Integer.bitCount(ans);
        return ans;
    }
}

public class Q461 {
    
}
