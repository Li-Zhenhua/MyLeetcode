package remaining101_200.easy;

import java.util.HashSet;
import java.util.Set;

/**给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

*/
//只想到集合
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }
        for (Integer integer : set) {
            return integer;
        }
        return 0;
    }
}

//位运算，太强了
/*
异或运算性质：

1、任何数和 0 做异或运算，结果仍然是原来的数
2、任何数和其自身做异或运算，结果是 0
3、异或运算满足交换律和结合律

 */
/*class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}*/


public class Question136 {
    
}
