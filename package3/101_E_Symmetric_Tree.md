
Problem Description:

```

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
```

Basic idea:

直接递归比较。比较 left.left 和 right.right，再比较 left.right 和 right.left

Python solution :

Firstly it's most intuitive solution : using dfs solution 

it will be below

```Python
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        
        return self.isSameTree(root.left,root.right)
    
    def isSameTree(self,left,right):
        if left is None and right is None:
            return True
        
        if left is None or right is None:
            return False
        
        return (left.val == right.val and self.isSameTree(left.left,right.right) 
                and self.isSameTree(left.right,right.left))

```


The iterative way will be like to use a queue to compare left&right respectively

```Python

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        queue = deque([root.left,root.right])
        
        while queue:
            
            left,right = queue.popleft(),queue.popleft()
            
            if left is None and right is None:
                continue
            
            if left is None or right is None or left.val!=right.val:
                return False
            
            queue.append(left.left)
            queue.append(right.right)
            
            queue.append(left.right)
            queue.append(right.left)
        
        return True

```


