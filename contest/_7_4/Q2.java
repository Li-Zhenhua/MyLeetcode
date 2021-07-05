package contest._7_4;

import java.util.Arrays;

class Solution222 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            dist[i] = (int)Math.ceil((double)dist[i]/speed[i]);
        }
        Arrays.sort(dist);
        
        int count = 1;
        for (int i = 1; i < n; i++) {
            //System.out.println(dist[i]);
            if(dist[i] <= count){
                break;
            }
            count++;
        }
        return count;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Solution222 s = new Solution222();
        int[] dist = new int[]{3,5,7,4,5};
        int[] speed = new int[]{2,3,6,3,2};
        s.eliminateMaximum(dist, speed);
    }
}
