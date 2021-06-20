package remaining200_gt.medium;

/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，
 * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 */


 //看思路后才反应过来，其实就是找公共前缀
 //第一种方法，按位右移，直到两数相等，通过位移次数确定公共前缀
/*class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while(left < right){
            left >>>= 1;
            right >>>= 1;
            count++;
        }
        return left << count;
    }
}*/

//第二种方法，依次消去right的最后一个1，直到right <= left
//此时表明right剩余的1组成了两者的公共前缀
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(left < right){
            int temp = right - 1;
            right = right & temp;//n与n-1进行并操作，将会使得原先最后一位的1消去
        }
        return right;
    }
}

public class Question201 {
    
}
