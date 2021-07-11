package remaining200_gt.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？

如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。

你允许：

装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
 */

 //DFS方法，记录出现的状态防止进入死循环
 //时间感觉有点久orz
/*class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Deque<int[]> stack = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        stack.push(new int[]{0,0});
        while(!stack.isEmpty()){
            int[] temp = stack.pop();
            String s = String.valueOf(temp[0]) + '-' + String.valueOf(temp[1]);
            //若状态已经存在时
            if(set.contains(s)){
                continue;
            }
            //添加相应的状态
            set.add(s);

            int x = temp[0], y = temp[1];
            if(x == targetCapacity || y == targetCapacity || x + y == targetCapacity){
                return true;
            }
            //装满任意一个水壶
            stack.push(new int[]{jug1Capacity,y});
            stack.push(new int[]{x,jug2Capacity});

            //清空任意一个水壶
            stack.push(new int[]{0,y});
            stack.push(new int[]{x,0});

            //从一个水壶向另外一个水壶倒水，直到装满或倒空
            stack.push(new int[]{Math.min(x+y, jug1Capacity),Math.max(0, y-jug1Capacity+x)});
            stack.push(new int[]{Math.max(0, x-jug2Capacity+y),Math.min(x+y,jug2Capacity)});
        }
        return false;
    }
}*/


//别人的一个巧妙做法
//装满小桶，往大桶倒，直到倒满大桶，此时小桶剩下remain，
//把大桶清空，小桶把remain倒往大桶，如此重复
//如果出现循环那说明无解
//感觉和数学算法已经很接近了
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0) return true;
        if(z > (x + y)) return false;
        int min = Math.min(x, y);
        int max = Math.max(x, y);

        boolean[] app = new boolean[max];   //记录是否出现一个周期，是则说明永远达不到目标

        int remain = 0;
        while(!app[remain]){
            app[remain] = true;
            remain = (remain + min) % max;
            if(remain == z || remain + max == z) return true;   //两种情况
        }
        return false;
    }
}

//数学方法
//贝祖定理，gcd最大公约数算法
//若a,b是整数,且gcd(a,b)=d，那么对于任意的整数x,y,
//ax+by都一定是d的倍数，特别地，一定存在整数x,y，使ax+by=d成立
/*class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        //因为gcd算法要求x，y不为0
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    public int gcd(int x, int y) {
        int remainder = x % y;
        while (remainder != 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }
}*/

public class Question365 {
    
}
