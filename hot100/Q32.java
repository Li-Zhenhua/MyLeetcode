package hot100;
/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */

 //注意是要连续的括号字符串！！！！
 //想了半天好像还是得用动态规划
 //定义dp[i] 表示以下标 i 字符结尾的最长有效括号的长度(一定包括下标 i )
 //转移方程有点难想确实
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            //当s.charAt(i) == '('时，dp[i]一定为0，就不用考虑了
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] =( i >= 2 ? dp[i-2] : 0 )+ 2;
                }else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    /*
                    s[i−1]== ‘)’，这种情况下，
                    如果前面有和s[i]组成有效括号对的字符，
                    即形如((....))，这样的话，
                    就要求s[i−1]位置必然是有效的括号对，
                    否则s[i]无法和前面对字符组成有效括号对。
                    这时，我们只需要找到和s[i]s[i]配对对位置，并判断其是否是 ( 即可。
                    和其配对对位置为：i−dp[i−1]−1。
                    */
                    /*
                    值得注意的是，i−dp[i−1]−1 和 i 组成了有效括号对，
                    这将是一段独立的有效括号序列，
                    如果之前的子序列是形如 (...) 这种序列，
                    那么当前位置的最长有效括号长度还需要加上这一段,即dp[i - dp[i - 1] - 2]这部分。
                    */
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}

//用栈的方法，关键是要始终保持栈底元素为当前已经遍历过的元素中
//「最后一个没有被匹配的右括号的下标」
/*class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}*/

//另一种想法，正反方向各来一次贪心算法
//从左往右是遇到右括号的数量比左括号多就置零
//反之，从右往左时遇到左括号的数量比右括号多就置零
/*class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}*/

public class Q32 {
    
}
