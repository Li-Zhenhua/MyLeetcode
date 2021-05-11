package array.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，
 * 其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。

假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。

 */

 //最简单的想法，但是效率肯定很低没得跑
/*class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) return nums[i];
        }
        return 0;
    }
}*/

//这个就是直接用额外数组空间实现，空间复杂度较高
/*class Solution {
    public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(count[nums[i]] == 1) return nums[i];
            count[nums[i]]++;
        }
        return 0;
}*/


//类似快慢指针好像也行哎
//不过这个过程真滴有点难想到

//从理论上讲，数组中如果有重复的数，
//那么就会产生多对一的映射，这样，形成的链表就一定会有环路
//1.数组中有一个重复的整数 <==> 链表中存在环
//2.找到数组中的重复整数 <==> 找到链表的环入口

//一些数学证明：
//先假设一些量：起点到环的入口长度为m，环的周长为c，
//在fast和slow相遇时slow走了n步。则fast走了2n步，fast比slow多走了n步，
//而这多走的n步全用在了在环里循环（因而n%c==0）
//fast 和 slow 相遇时，slow 在环中行进的距离是n-m，其中 n%c==0。
//这时我们再让 slow 前进 m 步————此时也就是在环中总共走了 n 步。
//而 n%c==0 即 slow 在环里面走的距离是环的周长的整数倍，
//就回到了环的入口了，而入口就是重复的数字。
//因此，fast置零从起点再一步一步走，最终会与slow在入口处相遇
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}




//一种新奇的二分法，学习了，以前没怎么见过这样二分的，虽然效率好像不怎么高

/*该二分法的思路是先猜一个数（有效范围 [left, right]里的中间数 mid），
然后统计原始数组中小于等于这个中间数的元素的个数 cnt，
如果 cnt 严格大于 mid，（注意我着重号的部分「小于等于」、「严格大于」）。
根据抽屉原理，重复元素就在区间 [left, mid] 里*/

/*public class Solution {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) /2;
            //或者
            //在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            //int mid = (l + r) >> 1;
            
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }
}*/


public class Question287 {
    
}
