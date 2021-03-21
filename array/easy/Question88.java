package array.easy;


/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，
 * 使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

 */

 //就是归并排序
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int index = 0;
        int[] temp = new int[m+n];
        while(i<m || j<n){
            if(i >= m){
                temp[index] = nums2[j];
                j++;
                index++;
            } else if(j >= n) {
                temp[index] = nums1[i];
                i++;
                index++;
            } else if(nums1[i] <= nums2[j] ){
                temp[index] = nums1[i];
                i++;
                index++;
            } else {
                temp[index] = nums2[j];
                j++;
                index++;
            }
        }
        //nums1 = temp;这样直接改变引用会有问题
        System.arraycopy(temp, 0, nums1, 0, m+n);
    }
}
//官方指针从后往前的方法
//这样节约内存空间，妙啊！
/*class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}*/



public class Question88 {
    
}
