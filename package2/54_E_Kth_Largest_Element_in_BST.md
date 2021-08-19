
Problem description :

```

给定一棵二叉搜索树，请找出其中第k大的节点。

 

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4

```

Idea : 这道题求的是第 K 大而不是第 K 小的数值，所以我们可以用反向中序遍历，
先遍历右节点，再是中间节点，最后是左节点

Python 解法如下：

```Python

class Solution:
    def kthLargest(self, root: TreeNode, k: int) -> int:
        self.k = k

        self.dfs(root)

        return self.res
    
    def dfs(self,root):
        if not root:
            return
        self.dfs(root.right)
        
        self.k -= 1
        if(self.k==0):
            self.res = root.val
            return
        
        self.dfs(root.left)

```

Golang 解法如下：

在函数外定义变量默认就是全局的

```Golang

var order int
var res int

func kthLargest(root *TreeNode, k int) int {
    order = k
    dfs(root)
    return res
}

func dfs(root *TreeNode) {
    if root==nil {
        return
    }

    dfs(root.Right)
    order -= 1

    if(order==0) {
        res = root.Val
        return
    }

    dfs(root.Left)
}

```

This is not the optimal solution for it doesnot make the use of
[BST]

```Java
class Solution {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> res=new ArrayList<Integer>();
        solve(root,res);
        return res.get(res.size()-k);
    }

    public void solve(TreeNode root,List<Integer> res) {
        if(root==null)
            return;
        solve(root.left,res);
        res.add(root.val);
        solve(root.right,res);
    }
}

```