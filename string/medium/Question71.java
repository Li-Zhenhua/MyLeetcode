package string.medium;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 
 * （以 '/' 开头），请你将其转化为更加简洁的规范路径。

在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 
表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 
对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。

请注意，返回的 规范路径 必须遵循下述格式：

始终以斜杠 '/' 开头。
两个目录名之间必须只有一个斜杠 '/' 。
最后一个目录名（如果存在）不能 以 '/' 结尾。
此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
返回简化后得到的 规范路径 。
 */

/*class Solution {
    public String simplifyPath(String path) {
        //这一步是一个预处理，防止出现形如"/a//b////c/d//././/.."这样无法取出最后一段的情况
        String pathChange = path + "/";
        StringBuilder sb = new StringBuilder();
        
        sb.append(pathChange.charAt(0));
        int pre = 0;
        // int count = 0;
        // for (int i = 1; i < path.length(); i++) {
        //     char curr = path.charAt(i);
        //     char p = path.charAt(pre);
        //     if(curr == '/' && p == '/') continue;
        //     if(curr == '.')
        // }
        
        //
        for (int i = 1; i < pathChange.length(); i++) {
            if(pathChange.charAt(i) == '/'){

                if(i - pre == 1 || "./".equals(pathChange.substring(pre+1,i+1))){
                    pre = i;
                    continue;
                }else if("../".equals(pathChange.substring(pre+1,i+1))){
                    if("/".equals(sb.toString())){
                        pre = i;
                        continue;
                    }else{
                        int len = sb.length()-1;
                        sb.deleteCharAt(len--);
                        while(sb.charAt(len) != '/'){
                            sb.deleteCharAt(len);
                            len--;
                        }
                    }
                }else{
                    sb.append(pathChange.substring(pre+1, i+1));
                }
                pre = i;
            }
        }

        if(sb.length() > 1 && sb.charAt(sb.length()-1) == '/'){
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }
}*/

//如果用栈的方法,其实上面第一次想到的方法也蕴含着栈的思想
class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();//用栈来模拟
        String[] strArr = path.split("/");//用/分割，多个/也视为/
        for(String str: strArr){//遍历
            //如果等于空或者等于.，那就没有影响
            if(str.equals("") || str.equals(".")){
                continue;
            }
            //如果等于..，那就要返回上一级目录，因此栈中弹出当前目录
            //此时可能栈是空
            if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
            //否则，栈中压入当前目录
            stack.push(str);
        }
        StringBuilder sb = new StringBuilder();
        Collections.reverse(stack);
        while(!stack.isEmpty()){
            String tmp = stack.pop();
            sb.append("/").append(tmp);
        }
        if(sb.length() == 0){
            sb.append("/");
        }
        return sb.toString();
    }
}

public class Question71 {
    // public static void main(String[] args) {
    //     Solution  s = new Solution33();
    //     s.simplifyPath("/a/./b/../../c/");
    // }
}
