package heap.easy;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。

请实现 KthLargest 类：

KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。

 */

 //练习手写实现
class KthLargest {

    int[] heap;
    int size;
    int index = 0;
    //初始化大小为k的小根堆
    public KthLargest(int k, int[] nums) {
        size = k;
        heap = new int[k];
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int x){
        if(index < size){
            heap[index] = x;
            shiftup(index);
            index++;
        }else if(heap[0] < x){//要求的是第k大元素
            heap[0] = x;
            shiftdown(0);
        }
        return heap[0];
    }
    
    public void shiftup(int x){
        int fatherNode = (x-1)/2;
        while(fatherNode >= 0 && heap[fatherNode] > heap[x]){
            int temp = heap[x];
            heap[x] = heap[fatherNode];
            heap[fatherNode] = temp;
            x = fatherNode;
            fatherNode = (x-1)/2;
        }
    }

    public void shiftdown(int x){
        int findIndexCompare = x*2+1;
        while(findIndexCompare < size){
            if (findIndexCompare != size -1 && heap[findIndexCompare] > heap[findIndexCompare + 1]) {
                findIndexCompare++;
            }
            if (heap[findIndexCompare] < heap[x]) {
                int temp = heap[x];
                heap[x] = heap[findIndexCompare];
                heap[findIndexCompare] = temp;
            }
            x = findIndexCompare;
            findIndexCompare = x*2+1;
        }
    }
}

//官方优先队列
/*class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}*/



public class Question703 {
    
}
