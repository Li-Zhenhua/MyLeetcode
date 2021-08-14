package 每日一题;

/**
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 */

//这就一道数学题，找规律呗，理论其实也就是找每个位上出现1的次数
//首先可以找到 
//0-9 中 1 的个数为 1
//0-99 中 1 的个数为 10+9*1+1=20
//0-999 中 1 的个数为 100+9*20+20=300
//0-9999 中 1 的个数为 1000+9*300+300=4000依次类推

//所以可以找一些数推理得到：
//2 -> 1
//52 -> 1（最后0-2的结果，也就是上一个结果）+ 5*1（经历了5轮0-9）+ 10（包含了完整的10-19） = 16
//252 -> 16 + 2*20 + 100 = 156
//1252 -> 156 + 1*300 + 253(只包含了1000-1252) = 709

class Solution {
    public int countDigitOne(int n) {
        int layerCount = 1;//用于记录每一个0 - 9....9中1的个数
        int baseFactor = 1; 
        int ans = 0;
        //从低位开始进行重构的数
        int reNum = 0;
        if(n % 10 >= 1) ans++; //个位数的时候
        reNum = n % 10;
        baseFactor *= 10;
        n /= 10;
        
        while(n != 0){
            int numTemp = n % 10;
            if(numTemp == 1){
                ans += reNum+1; //注意根据第二段注释，这里是从0-reNum，故个数要多加1
            }else if(numTemp > 1){
                ans += baseFactor;
            }

            ans += numTemp * layerCount;
            layerCount = baseFactor + 10*layerCount; //由上面第一段注释得到
            reNum = numTemp * baseFactor + reNum;
            baseFactor *= 10;
            n /= 10;

        }
        return ans;
    }
}

public class _8_13_Q233 {
    
}
