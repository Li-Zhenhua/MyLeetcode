package contest._6_26;

class Solution {
    public String removeOccurrences(String s, String part) {
        int n = part.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int index = 0;
        while(index <= sb.length()-n){
            if(sb.substring(index,index+n).equals(part)){
                sb.delete(index, index+n);
                //
                index = Math.max(0, index-n+1);
            }else{
                index++;
            }
        }

        return sb.toString();
    }
}

//别人做法，用函数接口
//第一个快一点好像
/*class Solution {
    public String removeOccurrences(String s, String part) {
        if (!s.contains(part)) {
            return s;
        }
        return removeOccurrences(s.replace(part, ""), part);
    }
}*/

/*class Solution {
    public String removeOccurrences(String s, String part) {
      while (s.contains(part)) {
        int i = s.indexOf(part);
        s = s.substring(0, i) + s.substring(i + part.length());
      }
      return s;
    }
  }*/

public class Q2 {
    
}
