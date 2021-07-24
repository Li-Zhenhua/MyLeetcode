package 每日一题;

/**
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。

有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。

替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 */

class Solution {
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < time.length()){
            // if(index==0 && time.charAt(index)=='?'){
            //     if(time.charAt(1)=='?'||time.charAt(1)<'4'){
            //         sb.append('2');
            //     }else{
            //         sb.append('1');
            //     }
            // }else if(index==1 && time.charAt(index)=='?'){
            //     if(time.charAt(0)=='?'||time.charAt(0)=='2'){
            //         sb.append('3');
            //     }else{
            //         sb.append('9');
            //     }
                
            // }else if(index==3 && time.charAt(index)=='?'){
            //     sb.append('5');
            // }else if(index==4 && time.charAt(index)=='?'){
            //     sb.append('9');
            // }else{
            //     sb.append(time.charAt(index));
            // }
            if(time.charAt(index) == '?'){
                if(index == 0){
                    if(time.charAt(1)=='?'){
                        sb.append("23");
                        index++;
                    }else if(time.charAt(1) < '4'){
                        sb.append("2");
                    }else{
                        sb.append("1");
                    }
                }else if (index == 1){
                    if(time.charAt(0) == '2'){
                        sb.append('3');
                    }else{
                        sb.append("9");
                    }
                }else if(index == 3){
                    sb.append('5');
                }else if(index == 4){
                    sb.append('9');
                }
            }else{
                sb.append(time.charAt(index));
            }
            index++;
        }
        return sb.toString();
    }
}

public class _7_24_Q1736 {
    
}
