package remaining200_gt.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。
 * 请你判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t ，
 * 同时又满足 abs(i - j) <= k 。

如果存在则返回 true，不存在返回 false。
 */

 //只能想到朴素做法orz

 //方法1：维护大小为k的TreeSet，注意需要防止溢出
/*class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long numTemp = (long) nums[i];
            //小于等于nums[i]的最大值
            // Long minMax = set.floor(numTemp);
            // if(minMax != null && numTemp-minMax <= t){
            //     return true;
            // }
            // //大于等于nums[i]的最小值
            // Long maxMin = set.ceiling(numTemp);
            // if(maxMin != null && maxMin-numTemp <= t){
            //     return true;
            // }

            //希望判断滑动窗口中是否存在某个数 y 
            //落在区间[x−t,x+t] 中，只需要判断滑动窗口中
            //所有大于等于 x - t 的元素中的最小元素
            //是否小于等于 x + t即可
            Long maxMin = set.ceiling(numTemp - t);
            if(maxMin != null && maxMin <= numTemp + t){
                return true;
            }

            set.add(numTemp);
            //当集合个数大于k时
            if(i >= k){
                set.remove((long) nums[i-k]);
            }
        }
        return false;
    }
}*/

//方法二：用桶排序方法
//按照元素的大小进行分桶，维护一个滑动窗口内的元素对应的元素
//对于元素 x，其影响的区间为 [x - t, x + t]。
//于是我们可以设定桶的大小为 t + 1。如果两个元素同属一个桶，
//那么这两个元素必然符合条件。如果两个元素属于相邻桶，
//那么我们需要校验这两个元素是否差值不超过 t。
//如果两个元素既不属于同一个桶，也不属于相邻桶，
//那么这两个元素必然不符合条件
class Solution {
    long size;
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        //桶大小t+1是因为这样才能使得相差为t的两个数在一个桶中
        //即0和t可以在一个桶中
        size = t + 1L;
        for (int i = 0; i < n; i++) {
            long u = nums[i] * 1L;
            long idx = getIdx(u);
            // 目标桶已存在（桶不为空），说明前面已有 [u - t, u + t] 范围的数字
            if (map.containsKey(idx)) return true;
            //由于存在上述判断，所以一个桶中最多只有一个元素，故可以用map
            // 检查相邻的桶
            long l = idx - 1, r = idx + 1;
            if (map.containsKey(l) && u - map.get(l) <= t) return true;
            if (map.containsKey(r) && map.get(r) - u <= t) return true;
            // 建立目标桶
            map.put(idx, u);
            // 移除下标范围不在 [max(0, i - k), i) 内的桶
            if (i >= k) map.remove(getIdx(nums[i - k] * 1L));
        }
        return false;
    }
    long getIdx(long u) {
        //由于0被正数的第一组所占，负数的第一组+1可以如同正数一样分组
        //然后-1是左移回去
        return u >= 0 ? u / size : ((u + 1) / size) - 1;
    }
}

public class Question220 {
    
}
