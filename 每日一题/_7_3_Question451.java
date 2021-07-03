package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */

 //第一想法是给个足够大的数组记录每个字符出现次数
 //一般ASCII字符用128就行
/*class Solution {
    public String frequencySort(String s) {
        int[][] count = new int[128][2];
        for (int i = 0; i < s.length(); i++) {
            int index = (int) s.charAt(i);
            count[index][0] = index;
            count[index][1]++;
        }
        //注意sort其实不能对一维的基本数据类型的数组进行排序
        //要使用comparator进行降序排列，需要将其封装成包装类
        //二维数组好像可以
        Arrays.sort(count,(a,b) -> {
            if(a[1] == b[1]){
                return a[0]-b[0];
            }else{
                return b[1]-a[1];//降序
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            char temp = (char)count[i][0];
            int n = count[i][1];
            if(n == 0){
                break;
            }
            while(n > 0){
                sb.append(temp);
                n--;
            }
        }
        return sb.toString();
    }
}*/

//第二种方法，用map(还可以用最大堆排序）
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

public class _7_3_Question451 {
    
}
