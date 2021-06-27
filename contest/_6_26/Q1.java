package contest._6_26;

class Solution {
    public boolean canBeIncreasing(int[] nums) {
        //int index = -1;
        if(nums.length == 2) return true;
        boolean flag = false;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] < nums[i+1]){
                continue;
            }else{
                if(!flag){
                    flag = true;
                    if(i == 0 || i == nums.length-2){
                        continue;
                    }
                    if(nums[i+1] > nums[i-1]){
                        continue;
                    }
                    if(nums[i] < nums[i+2]){
                        i++;
                        continue;
                    }
                    return false;

                }else{
                    return false;
                }
            }

        }
        return true;
    }
}

public class Q1 {
    
}
