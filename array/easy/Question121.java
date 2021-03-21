package array;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

 */

//自己做的方法内存太大了，想复杂了
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        
        int[] temp = new int[]{0,0,0};
        for (int i = 0;i < prices.length;i++) {
            if(i == 0){
                temp[0] = prices[0];
            } else{
                if(prices[i] < temp[0]){
                    if(temp[1]-temp[0] > temp[2]){
                        temp[2] = temp[1]-temp[0];
                    }
                    temp[0] = prices[i];
                    temp[1] = 0; 
                    continue;
                }

                if(prices[i] > temp[1]){
                    temp[1] = prices[i];
                    continue;
                }

            }
        }
        if(temp[1] == 0 && temp[2] == 0){
            return 0;
        }else {
            return Math.max(temp[1]-temp[0], temp[2]);
        } 
    }
}


//官方
/*public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}*/



public class Question121 {
    
}
