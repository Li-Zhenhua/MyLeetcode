package 每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：

1. set(string key, string value, int timestamp)

存储键 key、值 value，以及给定的时间戳 timestamp。
2. get(string key, int timestamp)

返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
如果没有值，则返回空字符串（""）。
 */

 //这次记住了TreeMap是一个有序的map，默认从小到大
class TimeMap {

    Map<String,TreeMap<Integer,String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> tr = map.getOrDefault(key, new TreeMap<>());
        tr.put(timestamp, value);
        map.put(key, tr);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        //因为TreeMap本身是有序的，floorKey表示找对应不大于key参数的最大那个数
        Integer k = map.get(key).floorKey(timestamp);
        if(k == null){
            return "";
        }
        return map.get(key).get(k);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

public class _7_10_Q981 {
    
}
