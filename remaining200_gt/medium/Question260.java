package remaining200_gt.medium;

/**
 * 给定一个整数数组 nums，
 * 其中恰好有两个元素只出现一次，其余所有元素均出现两次。 
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。

 

进阶：你的算法应该具有线性时间复杂度。
你能否仅使用常数空间复杂度来实现？
 */

 //淦！！分组异或，想到了异或没想明白分组
 //两个状态可以异或，但是三个及以上的状态就只能有限状态机，如137题  

 //第一次全部数进行异或，得到两个只出现一次的数的异或值
 //之后根据上述异或值中某个等于1对应的位，将全部数据分成两组
 //一组数全是对应位为0，另一组则是对应位为1
 //两组数再分别异或，可以得到两个数，即为答案
class Solution {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int i : nums) {
            temp = temp ^ i;
        }
        int factor = 1;
        while((factor & temp) == 0){
            factor <<= 1;
        }
        int num1 = 0, num2 = 0;
        for (int i : nums) {
            if((i & factor) == 0){
                num1 = num1 ^ i;
            }else{
                num2 = num2 ^ i;
            }
        }
        return new int[]{num1,num2};
    }
}

public class Question260 {
    
}
