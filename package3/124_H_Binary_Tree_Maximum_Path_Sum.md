
Problem description:

```

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

```

基本思路：对每一个 Node,它的路径有 4 种情况：

1. root.val
2. root.val + leftVal
3. root.val + rightVal
4. root.val + leftVal + rightVal

找出 `max()` value 然后对全局变量进行更新

在计算完它的 path 后，那么以它为基的 path 有 3 种：

1. root.val
2. root.val + leftVal
3. root.val + rightVal

我们返回 `max()` 中这三个的最大值

Solutions :

```Python

class Solution:
    
    maxRes = -float("inf")
    
    def maxPathSum(self, root: TreeNode) -> int:
        
        self.helper(root)
        
        return self.maxRes
    
    def helper(self, root):
            
        if root is None:
            return 0
        
        # left part value 
        leftValue = self.helper(root.left)
        # right part value
        rightValue = self.helper(root.right)
        # get the 4 cases
        pathSum = max(root.val,root.val+leftValue,root.val+rightValue,
                      root.val+leftValue+rightValue)

        if pathSum > self.maxRes:
            self.maxRes = pathSum
        
        return max(root.val,root.val+leftValue,root.val+rightValue)


```

---

---

上面的解法可以简化一下，如果某个 part 的值是负数那么我们可以直接返回 0，
对应 Python 解法如下：

```Python

class Solution:    
    maxRes = -float("inf")
    
    def maxPathSum(self, root: TreeNode) -> int:
        
        self.helper(root)
        
        return self.maxRes
    
    def helper(self, root):
            
        if root is None:
            return 0
        
        # left part value 
        leftValue = self.helper(root.left)
        leftValue = 0 if leftValue<0 else leftValue
        
        # right part value
        rightValue = self.helper(root.right)
        rightValue = 0 if rightValue<0 else rightValue
        
        # get the 4 cases
        pathSum = root.val+leftValue+rightValue

        if pathSum > self.maxRes:
            self.maxRes = pathSum
        
        return root.val + max(leftValue,rightValue)
```