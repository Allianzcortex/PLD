
problem description:

```

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.

 

Example 1:



Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
Example 2:



Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
Example 3:

Input: root = [1]
Output: 1
Explanation: Root is considered as good.

```

Idea : 这道题虽然是 medium 但思路应该算是 easy level，和 validate BST
是一样的，迭代循环时候纪录更新最大值，然后拿这个最大值和 Node 的值比较


Python Solution:

```Python

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        return self.dfs(root,root.val)
    
    
    def dfs(self,root,maxValue):
        if not root:
            return 0
        res = 0
        
        if root.val>=maxValue:
            res += 1
        
        res += self.dfs(root.left,max(root.val,maxValue))
        res += self.dfs(root.right,max(root.val,maxValue))
        
        return res

```

---

Golang Solution: 用一个 `math.MinInt64` 来避免重复判断 `root==nil`

```Golang

func goodNodes(root *TreeNode) int {
    
    return dfs(root,math.MinInt64)
}


func dfs(root *TreeNode,maxValue int) int {
    if root==nil {
        return 0
    }
    
    res := 0
    
    if root.Val >= maxValue {
        res += 1
    }
    
    res += dfs(root.Left,max(root.Val,maxValue))
    res += dfs(root.Right,max(root.Val,maxValue))
    
    return res
}

func max(a,b int) int {
    if(a>b) {
        return a
    }
    return b
}

```