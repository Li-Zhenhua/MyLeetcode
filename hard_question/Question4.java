package hard_question;

import java.beans.beancontext.BeanContext;
import java.text.BreakIterator;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 */

 //感觉有点类似归并排序
/*class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int lenTotal = len1 + len2;
        int midLen = lenTotal / 2 + 1;
        //其实可以优化空间复杂度，只要每次比较index1+index2和mid的值即可
        int[] temp = new int[midLen];
        int count = 0;
        int index1 = 0, index2 = 0;
        while(index1 < len1 || index2 < len2){
            if(index1 == len1){
                temp[count] = nums2[index2];
                index2++;
            }else if(index2 == len2){
                temp[count] = nums1[index1];
                index1++;
            }else if(nums1[index1] < nums2[index2]){
                temp[count] = nums1[index1];
                index1++; 
            }else{
                temp[count] = nums2[index2];
                index2++;
            }
            count++;
            if(count == midLen){
                break;
            }
        }
        if(lenTotal % 2 == 0){
            return (double) (temp[midLen-1]+temp[midLen-2])/2;
        }else{
            return (double) temp[midLen-1];
        }
    }
}*/

//降低时间复杂度的二分法

//假设我们要找第 k 小数，我们可以每次循环排除掉 k/2 个数
/*证明：
A 数组中比 A[k/2] 小的数有 k/2-1 个，
B 数组中，B[k/2] 比 A[k/2] 小，
假设 B[k/2] 前边的数字都比 A[k/2] 小，
也只有 k/2-1 个，
所以比 A[k/2] 小的数字最多有 k/1-1+k/2-1=k-2个，
所以 A[k/2] 最多是第 k-1 小的数。
而比 A[k/2] 小的数更不可能是第 k 小的数了，
所以可以把它们排除。 */
class Solution{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;  
    }
    
    //找第k小元素
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1 
        //其实就是使得参数中第二个数组的长度一定要不小于第一个数组长度
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            //将第二个数组对应的前面的元素删除
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            //将第一个数组对应的前面的元素删除
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
public class Question4 {
    
}
