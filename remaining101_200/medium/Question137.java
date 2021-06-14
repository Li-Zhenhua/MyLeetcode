package remaining101_200.medium;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，
 * 其余每个元素都恰出现 三次 。
 * 请你找出并返回那个只出现了一次的元素。
 */

 //突然想起来排序之后时间复杂度就不是O（n）了
 //而使用map空间复杂度又会增加
/*class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                count++;
            }else{
                if(count == 0){
                    return nums[i];
                }
                count = 0;
            }
        }
        if(count == 0){
            return nums[nums.length-1];
        }
        return 0;
    }
}*/

//运用位运算，由于除了一个数之外，其余所有数都出现了三次
//所以位运算下每一位求和后一定是3的倍数+单独的那个数对应的位的值
//故每一位求和后的值 % 3 结果就是单独的那个数
/*class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}*/

//真正的O（n)时间复杂度 + O（1）空间复杂度算法
//有限状态机，列写真值表，（数字电路的知识）
/*class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            //电路中的 a 和 b 是「同时」得出结果的
            int aNext = (~a & b & num) | (a & ~b & ~num);
            int bNext = ~a & (b ^ num);
            a = aNext;
            b = bNext;
        }
        return b;
    }
}*/

//简化真值表。将同时计算改成分别计算，先计算 b，再计算 a。
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }
}