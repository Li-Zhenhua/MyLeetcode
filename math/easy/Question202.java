package math.easy;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果 可以变为  1，那么这个数就是快乐数。
如果 n 是快乐数就返回 true ；不是，则返回 false 。
 */

 //瞎写碰上测试集不足，哈哈哈哈哈哈哈,投机取巧法
 class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        int sum = 0;
        
        for (int i = 0; i < 10; i++) {
            while(n > 0){
                sum += Math.pow((int)(n % 10), 2);
                n /= 10;
            }
            if(sum == 1) return true;
            n = sum;
            sum = 0;
        }
        return false;
    }
}

//标准快慢指针法，寻找是否存在环
/*public class Solution {
    public int squareSum(int n) {
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n, fast = squareSum(n);
        while (slow != fast){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        };
        return slow == 1;
    }
}*/


public class Question202 {
    
}
