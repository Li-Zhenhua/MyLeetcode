package array;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

 */


class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while(digits[index] == 9){
            digits[index] = 0;
            index--;
            if(index == -1){
                int[] ans = new int[digits.length + 1];
                ans[0] = 1;
                return ans;
            }
        }
        digits[index]++; //非9的位进行进1操作
        return digits;
    }
}

//看别人的方法，可以不用index，减少空间
/*class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}*/


public class Question66 {
    
}
