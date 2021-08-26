package 每日一题;

import java.util.Arrays;

/**
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。

每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。

返回载到每一个人所需的最小船数。(保证每个人都能被船载)。

 
 */

 //注意最多载两个人！！！！
 //那就简单多了，直接双指针
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length-1;
        int ans = 0;
        while(left <= right){
            // if(people[right] == limit){
            //     right--;
            //     ans++;
            //     continue;
            // }

            if(people[left] + people[right] <= limit){
                left++;
            }

            ans++;
            right--;

        }
        return ans;
    }
}

public class _8_26_Q881 {
    
}
