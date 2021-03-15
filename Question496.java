import java.util.HashMap;
import java.util.Stack;

/**
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1
 */
//完全不会orz
//要用到单调栈和hashmap
class Solution{
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        for (int n : nums2) {
            while(!stack.isEmpty() && stack.peek() < n){
                map.put(stack.pop(), n);
            } 
            stack.push(n);
        }        
        for (int i = 0; i<ans.length; i++) {
            ans[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return ans;
    }
}

//单调栈中存放的元素最好是下标而不是值，因为有的题目需要根据下标计算，这样泛化性更好
/*class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]){
                int j = stack.pop();
                map.put(nums2[j],nums2[i]); // 此时nums2[j]<nums2[i]
            }
            stack.push(i); // 下标入栈
        }
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}*/
