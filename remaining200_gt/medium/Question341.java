package remaining200_gt.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。

列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 */

 /**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//这种方法有点违背迭代器的思想
/*public class NestedIterator implements Iterator<Integer> {

    Deque<Integer> queue = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        //因为保证next之前调用过hasNext
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        if(queue.isEmpty()){
            return false;
        }
        return true;
    }

    public void dfs(List<NestedInteger> nestedList){
        for (NestedInteger neIterator : nestedList) {
            if(neIterator.isInteger()){
                queue.add(neIterator.getInteger());
            }else{
                dfs(neIterator.getList());
            }
        }
    }
}*/

//用栈模拟递归过程
/*
我们在栈中存储的是指向列表当前遍历的元素的指针（下标）。
每次向下搜索时，取出列表的当前指针指向的元素并将其入栈，
同时将该指针向后移动一位
*/
public class NestedIterator implements Iterator<Integer> {
    // 存储列表的当前遍历位置
    private Deque<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        // 由于保证调用 next 之前会调用 hasNext，直接返回栈顶列表的当前元素
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> it = stack.peek();
            if (!it.hasNext()) { // 遍历到当前列表末尾，出栈
                stack.pop();
                continue;
            }
            // 若取出的元素是整数，则通过创建一个额外的列表将其重新放入栈中
            NestedInteger nest = it.next();
            if (nest.isInteger()) {
                List<NestedInteger> list = new ArrayList<NestedInteger>();
                list.add(nest);
                stack.push(list.iterator());
                return true;
            }
            stack.push(nest.getList().iterator());
        }
        return false;
    }
}



/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class Question341 {
    
}
