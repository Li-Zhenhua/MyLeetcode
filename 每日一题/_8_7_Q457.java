package 每日一题;
/**
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：

如果 nums[i] 是正数，向前 移动 nums[i] 步
如果 nums[i] 是负数，向后 移动 nums[i] 步
因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。

数组中的 循环 由长度为 k 的下标序列 seq ：

遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
所有 nums[seq[j]] 应当不是 全正 就是 全负
k > 1
如果 nums 中存在循环，返回 true ；否则，返回 false 。
 */

 //第一想法是快慢指针找到环中的元素，然后遍历整个环看是否符合条件
 //因为数组中不存在0，所以一定会有环的出现
 //但是发现好像有两个环情况就不能用快慢指针了（如【3,1,2】）
 //holly shit 原来就是快慢指针，只不过细节没想好
 //思考了一下，好像有些地方想多了，题目要求是要得出是否有满足条件的循环而已
 /*
 期间每移动一次，我们都需要检查当前单向边的方向是否与初始方向是否一致，
 如果不一致，我们即可停止遍历，因为当前路径必然不满足条件。
 为了降低时间复杂度，我们可以标记每一个点是否访问过，标记方法就是直接将原数组中的数置零！！
 这样就可以不用而外的flag数组了
 过程中如果我们的下一个节点为已经访问过的节点，则可以停止遍历
 */
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0) continue;

            int slow = i;
            int fast = next(nums, slow); //确保是正数
            //首先判断行进方向是否一致
            while(nums[slow]*nums[fast] > 0){
                if(slow == fast){
                    if(slow != next(nums, fast)){
                        return true;
                    }else{
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, fast);
                if(nums[slow]*nums[fast] < 0) break; //中间有一步行进方向反向时
                fast = next(nums, fast);
            }

            //将上一轮找寻过程中遍历过的元素置零
            //这样的算法其实也是O（n）时间复杂度
            int temp = i;
            while(nums[temp] * nums[next(nums, temp)] > 0){
                int temp2 = temp;
                temp = next(nums, temp);
                nums[temp2] = 0;
            }
        }
        return false;
    }

    public int next(int[] nums, int x){
        int n = nums.length;
        return ((x + nums[x]) % n + n) % n;
    }
}

public class _8_7_Q457 {
    
}
