package array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 */

 //哪天降了就卖出
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit0 = 0;
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < maxPrice){
                maxProfit0 += (maxPrice - minPrice);
                minPrice = prices[i];
                maxPrice = 0;
                continue;
            }
            
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else {
                if(prices[i] > maxPrice){
                    maxPrice = prices[i];
                }
            }
        }
        if(maxPrice != 0){
            maxProfit0 += (maxPrice - minPrice);
        }
        return maxProfit0;
    }
}

//贪心算法，此外竟然还能用动态规划
/*class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}*/


public class Question122 {
    
}
