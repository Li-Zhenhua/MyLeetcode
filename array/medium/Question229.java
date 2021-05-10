package array.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。

 */

 //第一反应就是用这个hashmap
/*class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> maps = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int countNum = maps.getOrDefault(nums[i], 0);
            if(countNum > nums.length/3) continue;
            if(countNum+1 > nums.length/3){
                ans.add(nums[i]);
            }
            maps.put(nums[i], countNum+1);
        }
        return ans;
    }
}*/

//更进一步，基于摩尔投票法
//如果至多选一个代表，那他的票数至少要超过一半（⌊ 1/2 ⌋）的票数；
//如果至多选两个代表，那他们的票数至少要超过 ⌊ 1/3 ⌋ 的票数；
//如果至多选m个代表，那他们的票数至少要超过 ⌊ 1/(m+1) ⌋ 的票数。
//题目隐含条件就是至多只能找到2个出现超过 ⌊ n/3 ⌋ 次的元素，反证法可证

/*1.如果投A（当前元素等于A），则A的票数++;
2.如果投B（当前元素等于B），B的票数++；
3.如果A,B都不投（即当前与A，B都不相等）,那么检查此时A或B的票数是否减为0：
    3.1 如果为0,则当前元素替代票数为0的元素成为新的候选人；
    3.2 如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均减一；*/

//遍历结束后选出了两个候选人，但是这两个候选人是否满足>n/3，
//还需要再遍历一遍数组，找出两个候选人的具体票数

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        //初始化：定义两个候选人及其对应的票数
        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;
        for (int num : nums) {
            if (num == candidateA) {
                countA++;
                continue;
            }else if (num == candidateB) {
                countB++;
                continue;
            }
    
            //此时当前值和AB都不等，检查是否有票数减为0的情况，
            //如果为0，则更新候选人
            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }else if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }
            //若此时两个候选人的票数都不为0，且当前元素不投AB，
            //那么A,B对应的票数都要减一;
            countA--;
            countB--;
        }
    
        //上一轮遍历找出了两个候选人candidateA，candidateB
        //但是这两个候选人是否均满足票数大于N/3仍然没法确定，
        //需要重新遍历票数
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == candidateA)
                countA++;
            else if (num == candidateB)
                countB++;
        }
        if (countA > nums.length / 3)
            ans.add(candidateA);
            
        if (countB > nums.length / 3)
            ans.add(candidateB);
        return ans;
    }
}

public class Question229 {
    
}
