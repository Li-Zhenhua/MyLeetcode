package 每日一题;

/**
 * 给你一个字符数组 chars ，请使用下述算法压缩：

从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：

如果这一组长度为 1 ，则将字符追加到 s 中。
否则，需要向 s 追加字符，后跟这一组的长度。
压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。

请在 修改完输入数组后 ，返回该数组的新长度。

你必须设计并实现一个只使用常量额外空间的算法来解决此问题。

提示：

1 <= chars.length <= 2000
chars[i] 可以是小写英文字母、大写英文字母、数字或符号
 */

 //注意还得原地修改数组
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        char currChar = ' ';
        int count = 1;
        //因为index作用就可以代替ans
        //int ans = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(chars[i] == currChar){
                count++;
                continue;
            }else{
                if(count != 1){
                    //ans++;
                    //chars[index++] = currChar;
                    //count /= 10;
                    String s = String.valueOf(count);
                    for (int j = 0; j < s.length(); j++) {
                        chars[index++] = s.charAt(j);
                    }
                    //ans += s.length();
                }
                count=1;

                //ans++;
                currChar = chars[i];
                chars[index++] = currChar;
                
            }
        }
        //注意最后的一个数字要额外处理一下
        if(count != 1){
            String s = String.valueOf(count);
            for (int j = 0; j < s.length(); j++) {
                chars[index++] = s.charAt(j);
            }
            //ans += s.length();
        }

        return index;
    }
}

public class _8_21_Q443 {
    
}
