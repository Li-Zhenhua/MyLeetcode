package remaining101_200.easy;

import java.util.ArrayList;
//import java.util.List;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        innerList.add(1);
        list.add(innerList);
        if(numRows == 1) return list;
        for(int i = 1; i < numRows; i++){
            innerList = new ArrayList<>();
            innerList.add(1);
            if(i > 1){
                for(int j = 1; j < i; j++){
                    int num = list.get(i-1).get(j-1) + list.get(i-1).get(j);
                    innerList.add(num);
                }
            }
            innerList.add(1);
            list.add(innerList);
        }
        return list;

    }
}

public class Question118 {
    
}
