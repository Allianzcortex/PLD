
Problem descriptioN:

```
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

 

Example 1:


Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:


Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

```

Basic idea : 根据 logic 来一步步解

这道题一样有两种解法，递归和回溯：

下面是回溯解法

```Python

class Solution(object):
    def sumNumbers(self, root):
        if not root:
            return 0
        stack, res = [(root, root.val)], 0
        while stack:
            node, value = stack.pop()
            
            if not node.left and not node.right:
                    res += value
            if node.right:
                    stack.append((node.right, value*10+node.right.val))
            if node.left:
                    stack.append((node.left, value*10+node.left.val))
        return res
```

如下则是递归解法：

```Python

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        res = []
        
        self.dfs(root,res,0)
        
        return sum(res)
    
    def dfs(self,root,res,curr_val):
        
        if not root:
            return
        
        new_val = curr_val*10+root.val
        
        if root.left is None and root.right is None:
            res.append(new_val)
            return
        
        self.dfs(root.left,res,new_val)
        self.dfs(root.right,res,new_val)

```

时空复杂度分析如下：

1. 时间：每个节点都要 visit 一次，所以假设有 N 个节点，那么时间复杂度为 O(N)

2. 空间：空间复杂度与时间复杂度有关。每个 level 遍历时间复杂度都是 O(1) 

如果这个 tree 是 balanced，那么会有 O(logN) level，空间复杂度为 O(logN)
如果这个 tree 是 skewed ，那么会有 O(N) level，空间复杂度为 O(N)

---

