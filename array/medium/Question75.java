package array.medium;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
 * 原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 */

 //直接调用sort作弊方法
/*class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}*/

//一般化，只有三种数，考虑类似快速排序的方法
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0, two = n-1;
        //int temp;
        for (int i = 0; i <= two; ) {
            if(nums[i] == 0){
                //把这部分抽出来另作为一个函数更好
                //重用多次的抽离出来空间复杂度会降低
                //根据我的理解，可能是放在栈空间了
                /* temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp; */
                swap(nums, i, zero);
                zero++;
                i++;
            }else if (nums[i] == 2){
                /* temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp; */
                swap(nums, i, two);
                two--;
            }else{
                i++;
            }
        }
    }

    public void swap(int[]nums, int i1, int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}

public class Question75 {
    
}
