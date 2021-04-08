package greedy.easy;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，
其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，
能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。

 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;//要先判断n是否为0
        int k = 0;
        while(k < flowerbed.length){
            if(flowerbed[k] == 1){
                k = k + 2;
                continue;
            } 
            //因为上述找到1就跳2步，而1处在位置的下一个不可能是1
            //故新找到的位置前一位肯定是0，不用再判断
            //只用判断下一位的数值
            //以下的情况都已经是满足flowerbed[k] = 0的情况
            if(k == flowerbed.length-1 || flowerbed[k + 1] == 0){
                n--;
                if(n == 0)
                    return true;
                //相当于此时该位置重新设置为1，故要跳2步
                k = k + 2;
            } else {
                //此时下一个位置就是1，跳3步就省了再判断一次
                k = k + 3;
            }
        }
        return false;
    }
}

public class Question605 {
    
}
