package remaining101_200.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 */

 //第一反应就是map，果然性能很差orz
/*class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        int k;
        for (int i = 0; i < nums.length; i++) {
            if(!count.containsKey(nums[i])) {
                k = 0;
            } else{
                k = count.get(nums[i]);
            }  
            if(++k > nums.length/2) return nums[i];
            count.put(nums[i], k);
        }
        return 0;
    }
}*/

//排序法，因为有某个数出现次数大于n/2，故中位数一定是它
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

//解法3：摩尔投票法
//摩尔投票法，遇到相同的数，就投一票，遇到不同的数，就减一票，最后还存在票的数就是众数
/*class Solution {
    public int majorityElement(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }
}*/


public class Question169 {
    
}
