package remaining101_200.medium;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）
 * 使之组成一个最大的整数。

注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */

 //
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] stringNums = new String[n];
        for (int i = 0; i < n; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }
        //比较两个拼接的字符串大小，compareTo按照字典序来
        Arrays.sort(stringNums, (a,b) -> {
            return (b+a).compareTo(a+b);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(stringNums[i]);
        }
        //一个极端情况，数组全是0，要去除前导0
        int index = 0;
        n = sb.length();
        while(sb.charAt(index) == '0' && index < n-1){
            index++;
        }
        return sb.substring(index);
    }
}