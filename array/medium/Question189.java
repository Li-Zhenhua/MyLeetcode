package array.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

进阶：

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？

 */

class Solution {
    public void rotate(int[] nums, int k) {
        //1.利用额外数组
        /*int[] ans = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
           ans[i] = nums[(i+k) % n]; 
        }
        System.arraycopy(ans, 0, nums, 0, n);*/

        //2.进行翻转找规律

        /*int n = nums.length;
        reverse(nums,0,n-1);
        reverse(nums, 0, k%n-1);
        reverse(nums, k%n, n-1);
        


    }

    public void reverse(int[] nums, int left, int right){
        int n = right - left + 1;
        for (int i = 0; i < n/2; i++) {
            int temp = nums[left+i];
            nums[left+i] = nums[right-i];
            nums[right-i] = temp;
        }
    }*/

    //3.官方答案：环状替换，
    //gcd 指的是最大公约数，有非1的公因子会导致数组中有些数取不到
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            int count = gcd(k, n);
            for (int start = 0; start < count; ++start) {
                int current = start;
                int prev = nums[start];
                do {
                    int next = (current + k) % n;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    current = next;
                } while (start != current);
            }
        }
    
        public int gcd(int x, int y) {
            return y > 0 ? gcd(y, x % y) : x;
        }
    }

    }
}

public class Question189 {
    
}
