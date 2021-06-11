package remaining1_100.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /**
  * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。
  请在不改变其结构的情况下，恢复这棵树。

进阶：使用 O(n) 空间复杂度的解法很容易实现。
你能想出一个只使用常数空间的解决方案吗？
  */

//最简单想法其实就是中序遍历，O(1)空间复杂度没想明白
 /* class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root,list);
        TreeNode x = null;
        TreeNode y = null;
        //找出可能存在错误交换的节点x和y
        for(int i=0;i<list.size()-1;++i) {
            if(list.get(i).val>list.get(i+1).val) {
                y = list.get(i+1);
                if(x==null) {
                    x = list.get(i);
                }
            }
        }
        //交换节点值，恢复二叉搜索树
        if(x!=null && y!=null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    //中序遍历     
    private void dfs(TreeNode node,List<TreeNode> list) {
        if(node==null) {
            return;
        }
        dfs(node.left,list);
        list.add(node);
        dfs(node.right,list);
    }
}*/

//稍微节省一点空间的办法，也就是将数组变成指向要交换节点的两个指针
class Solution {
  //用两个变量x，y来记录需要交换的节点
  private TreeNode x = null;
  private TreeNode y = null;
  private TreeNode pre = null;//记录前一个节点
  public void recoverTree(TreeNode root) {
      dfs(root);
      //如果x和y都不为空，说明二叉搜索树出现错误的节点，将其交换
      if(x!=null && y!=null) {
          int tmp = x.val;
          x.val = y.val;
          y.val = tmp;
      }
  }

  //中序遍历二叉树，并比较上一个节点(pre)和当前节点的值，如果pre的值大于当前节点值，则记录下这两个节点
  private void dfs(TreeNode node) {
      if(node==null) {
          return;
      }
      dfs(node.left);
      if(pre==null) {
          pre = node;
      }
      else {
          if(pre.val>node.val) {//因为原来二叉搜索树中序遍历是一个升序序列，交换两个值后只可能出现两种情况
              y = node;//2、某两个不相邻数换，此时会出现两次逆序的情况
              if(x==null) {//1、相邻的两个数换，只出现一次逆序
                  x = pre;
              }
          }
          pre = node;
      }
      dfs(node.right);
  }
}

//常数空间的莫里斯遍历
/*class Solution {
	public void recoverTree(TreeNode root) {
		if(root==null) {
			return;
		}
		TreeNode x = null;
		TreeNode y = null;
		TreeNode pre = null;
		TreeNode tmp = null;
		while(root!=null) {
      //寻找当前root节点的前驱节点，也就是root的左子节点的最右侧节点
      //中序遍历时只有左节点都遍历完了，才到当前的根节点
			if(root.left!=null) {
				tmp = root.left;
				while(tmp.right!=null && tmp.right!=root) {
					tmp = tmp.right;
				}
				if(tmp.right==null) {
          //找到前驱节点，令前驱节点的右节点指向root，即前驱节点遍历完后就到当前的root
          //这一步是节省空间的关键，但是后续要再次遍历root的左节点
          //时间换空间
					tmp.right = root;
					root = root.left;
				}
				else {
          //此时是tmp.right == root
          //也就是说，此时已经使得前驱节点指向root后的第二次遍历到root左子节点的最右侧节点
          //即此时可以比较前驱节点和当前root节点的值的大小来判断是不是错误节点了
					if(pre!=null && pre.val>root.val) {
            //找到错误节点
						y = root;
						if(x==null) {
							x = pre;
						}
					}
					pre = root;
					tmp.right = null;
					root = root.right;
				}
			}
			else {
        //此时当前root节点没有左子节点，可以遍历当前root节点
				if(pre!=null && pre.val>root.val) {
					y = root;
					if(x==null) {
						x = pre;
					}
				}
				pre = root;
				root = root.right;
			}
		}
		if(x!=null && y!=null) {
			int t = x.val;
			x.val = y.val;
			y.val = t;
		}
	}
}*/

public class Question99 {
    
}
