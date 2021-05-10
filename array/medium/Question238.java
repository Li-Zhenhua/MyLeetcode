package array.medium;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 
 * 
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）
 * 的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？
（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

 */

/*class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] numsTemp = new int[n];
        int[] ans = new int[n];
      
        //其实这里也不必完全翻转
        for (int i = 0; i < n; i++) {
            numsTemp[i] = nums[n-1-i];
        }
        
        //这里记录其实也差了一位，所以导致上述需要翻转
        //应该这样存：第i位存的是其左边所有数之积
        //不应该包括第i位的数
        for (int i = 1; i < n; i++) {
            nums[i] *= nums[i-1];
            numsTemp[i] *= numsTemp[i-1];
        }
        ans[0] = numsTemp[n-2];
        ans[n-1] = nums[n-2];
        for (int i = 1; i < n-1; i++) {
            ans[i] = nums[i-1]*numsTemp[n-i-2];
        }
        return ans;
    }
}*/

//优化上述空间复杂度，用ans数组代替左数组
//右数组用一个乘积数表示，每次对应于每一个左数组中的值
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // ans[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 ans[0] = 1
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 ans[i]，右边的乘积为 R
            ans[i] = ans[i] * R;
            //更新下一个数，即左边一个数的所有右侧元素乘积
            R *= nums[i];
        }
        return ans;
    }
}


public class Question238 {
    
}
