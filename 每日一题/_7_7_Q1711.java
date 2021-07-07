package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。

你可以搭配 任意 两道餐品做一顿大餐。

给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。

注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 */

 //用map
/*class Solution {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2; //两数之和的最大值
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            //对每一个数找能与其组合成2的幂的另一个数
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            //更新map中对应值的个数
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }
}*/

//看到的另一种改用数组代替map的方法，思路一样
//运行时间大大降低
class Solution {
	public static int countPairs(int[] ds) {
		int min, max;
		min = max = ds[0];
        //先找到最大最小值
		for (int v : ds) {
			if (v < min)
				min = v;
			else if (v > max)
				max = v;
		}
        //根据最大最小值确定数组的大小
		int[] map = new int[max - min + 1];
		long res = 0;
        //这一步就是和上面一样，找每个数对应的能与其组合成2的幂的另一个数
		for (int v : ds) {
			for(int s=1;;s<<=1) {
				int x = s - v;
				if(x < min) continue;
				if(x > max) break;
				res += map[x-min];
			}
            //更新对应的数组元素的值
			map[v - min]++;
		}
		return (int) (res % 1_000_000_007L);
	}
}

public class _7_7_Q1711 {
    
}
