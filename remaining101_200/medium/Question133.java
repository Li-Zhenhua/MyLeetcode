package remaining101_200.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。

图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 */

 //其实想清楚了也就是遍历整个图而已，dfs和bfs均可
 //感觉比较常用dfs，递归调用比较好些
class Solution {
    //记录是否已经遍历过，防止图的死循环的出现
    //同时记录每个原来图中的节点对应的深拷贝节点
    private Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        //拷贝
        Node newNode = new Node(node.val, new ArrayList<Node>());
        //将原图的node与拷贝的图的node对应起来
        visited.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            //递归调用，拷贝该节点的邻接节点
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }
}

//bfs形式
/*class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            for (Node n : tmp.neighbors) {
                if (!lookup.containsKey(n)) {
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                    queue.offer(n);
                }
                lookup.get(tmp).neighbors.add(lookup.get(n));
            }
        }
        return clone;
    }
}*/

public class Question133 {
    
}
