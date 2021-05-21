package string.medium;

/**
 * 给你两个版本号 version1 和 version2 ，请你比较它们。

版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。
每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。
修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，
下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。

比较版本号时，请按从左到右的顺序依次比较它们的修订号。
比较修订号时，只需比较 忽略任何前导零后的整数值 。
也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，
则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，
因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。

返回规则如下：

如果 version1 > version2 返回 1，
如果 version1 < version2 返回 -1，
除此之外返回 0。
 */


//直接上双指针比较
class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int index1 = 0,index2 = 0;
        //这样可以遍历所有情况
        while(index1 < len1 || index2 < len2){
            //给予各个分区块的数的默认值
            //这样即使其中一个已经是没有的，也可以得到默认值0
            int num1 = 0, num2 = 0;
            while(index1 < len1 && version1.charAt(index1) != '.'){
                num1 = num1*10 + (version1.charAt(index1)-'0');
                index1++;
            }

            while(index2 < len2 && version2.charAt(index2) != '.'){
                num2 = num2*10 + (version2.charAt(index2)-'0');
                index2++;
            }

            if(num1 < num2){
                return -1;
            }else if(num1 > num2){
                return 1;
            }
            index1++;
            index2++;
        }
        return 0;
    }
}

//官方用split做的方法
/*class Solution {
    public static int compareVersion(String version1, String version2) {
        //原来是这里的问题，注意这里需要转义！！！！
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int m = v1.length;
        int n = v2.length;
        int index = 0;
        while (index < m && index < n) {
            if (Integer.parseInt(v1[index]) > Integer.parseInt(v2[index])) return 1;
            else if (Integer.parseInt(v1[index]) < Integer.parseInt(v2[index])) return -1;
            else {
                index++;
            }
        }
        if (index < m) {
            for (int i = index; i < m; i++) {
                if (Integer.parseInt(v1[i]) >= 1) return 1;
            }
        }
        if (index < n) {
            for (int i = index; i < n; i++) {
                if (Integer.parseInt(v2[i]) >= 1) return -1;
            }
        }
        return 0;
    }
}*/

public class Question165 {
    
}
