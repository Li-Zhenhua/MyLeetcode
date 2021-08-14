package hot100;

import java.util.ArrayList;
import java.util.List;


//原地遍历，根据数组中的值查找对应下标的数
//遍历过的数都置为0，这样可以防止重复遍历
//最后没有遍历到的数的下标即为要求的结果
/*class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0) continue;
            int index = nums[i]-1;
            while(index != -1){
                int temp = index;
                index = nums[temp]-1;
                nums[temp] = 0;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}*/


//官方答案
//遍历 nums，每遇到一个数 x，就让 nums[x−1] 增加 n。
//由于 nums 中所有数均在 [1,n] 中，增加以后，这些数必然大于 n。
//最后我们遍历 nums，若 nums[i] 未大于 n，就说明没有遇到过数 i+1。
//这样我们就找到了缺失的数字。
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}

public class Q448 {
    
}
