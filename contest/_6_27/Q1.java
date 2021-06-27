package contest._6_27;

import java.util.Arrays;

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n-2], b = nums[n-1];
        int c = nums[0], d = nums[1];
        return a*b-c*d;
    }
}

public class Q1 {
    
}
