package contest._6_26;

//贪心算法，其实有点类似买卖股票问题，找每一个卖出的节点
//不过这里可以在同一个时间节点卖了又买，其实相当于没有在该时间节点买卖
//也就是不选取对应位置的值
class Solution {
    public long maxAlternatingSum(int[] nums) {
        long maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //每一个类似股票卖出的节点，即“股票涨了”就卖
            //前一个节点也就是“买入”节点
            //其实买入节点如果没有“卖出”操作，则对应于结果子序列的奇数下标的值
            //同理，卖出节点如果后续没有“买入”操作，则对应于偶数下标的值
            if(nums[i] > nums[i-1]){
                maxSum += nums[i]-nums[i-1];
            }
        }
        return maxSum;
    }
}

//一般的动态规划思路
//f[i] 表示 索引 i 处能得到的最大和交替和
//f[i][0] 表示以 i 时长度为奇数的最大交替和
//f[i][1] 表示以 i 时长度为偶数的最大交替和
/*public long maxAlternatingSum(int[] nums) {
    int n = nums.length;
    long[][] f = new long[n][2];
    f[0][0] = nums[0];
    f[0][1] = Integer.MIN_VALUE;
    for (int i = 1; i < n; i++) {
      f[i][0] = Math.max(f[i - 1][0], Math.max(nums[i], f[i - 1][1] + nums[i]));
      f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - nums[i]);
    }
    //由于题中描述 nums[i]>0 所以取奇数列的值一定大于偶数列，
    //最后返回f[n - 1][0]即可
    return f[n - 1][0];

    //空间优化，用两个变量即可
    int n = nums.length;
    long odd = nums[0], even = Integer.MIN_VALUE;
    for (int i = 1; i < n; i++) {
      long t1 = odd, t2 = even;
      odd = Math.max(t1, Math.max(nums[i], t2 + nums[i]));
      even = Math.max(t2, t1 - nums[i]);
    }
    return odd;
  }*/



public class Q3 {
    
}
