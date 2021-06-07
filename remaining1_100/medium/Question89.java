package remaining1_100.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。

格雷编码序列必须以 0 开头。

 
 */

 //得先找找规律，镜像法
 /*给 G(n) 阶格雷码每个元素二进制形式前面添加 0，得到 G'(n)；
设 G(n)集合倒序（镜像）为 R(n)，给 R(n)每个元素二进制形式前面添加 1，得到 R'(n)；
G(n+1) = G'(n) ∪ R'(n) 拼接两个集合即可得到下一阶格雷码。*/
//类似动态规划的思想
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int addNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size()-1; j >= 0; j--) {
                ans.add(ans.get(j) + addNum);
            }
            addNum = addNum << 1;
        }
        return ans;
    }
}

//格雷码的公式算法，即二进制数和格雷码的转换
//最高位保留：Gn-1 = Bn-1
//其余位：Gi = Bi+1 异或 Bi, i+1为下标
/*class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        for(int binary = 0;binary < 1 << n; binary++){
            gray.add(binary ^ binary >> 1);
        }
        return gray;
    }
}*/

public class Question89 {
    
}
