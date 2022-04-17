
Problem description:

```

Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.

The length of the path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [5,4,5,1,1,5]
Output: 2
Example 2:


Input: root = [1,4,5,4,4,5]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
The depth of the tree will not exceed 1000.

```

Basic idea :

这道题和 543 `Diameter of Binary Tree` 非常相似，也就是说：

a) 对每个节点来说，最长的 Univalue Path 是 left+right

b) 对每个节点来说，要返回的最长的 path 是 max(left,right)

c) 不过有一点，如果发现 root.val!=root.left.val，那么该节点的 leftLength 就会被重置为 0

---

Python 代码如下：

```Python

class Solution:
    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        """
        
        """
        self.res = 0
        self.traverse(root)
        return self.res
    
    
    def traverse(self,root):
        
        if not root:
            return 0
        
        leftLength,rightLength = self.traverse(root.left),self.traverse(root.right)
        
        if root.left and root.val==root.left.val:
            leftLength += 1
        else:
            leftLength = 0
        
        if root.right and root.val==root.right.val:
            rightLength += 1
        else:
            rightLength = 0
        
        self.res = max(self.res,leftLength+rightLength)
        
        return max(leftLength,rightLength)

```

一种优化方法是把 parent_val 作为 dfs 函数的参数传递进去

```Python

class Solution:
    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        """
        
        """
        self.res = 0
        self.traverse(root,None)
        return self.res
    
    
    def traverse(self,root,parent_val):
        
        if not root:
            return 0
        
        leftLength,rightLength = self.traverse(root.left,root.val),self.traverse(root.right,root.val)
        
        self.res = max(self.res,leftLength+rightLength)
        
        return 1+ max(leftLength,rightLength) if root.val == parent_val else 0

```