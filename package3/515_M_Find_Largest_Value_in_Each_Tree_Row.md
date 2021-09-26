
Problem description:

```
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,null,2]
Output: [1,2]
Example 5:

Input: root = []
Output: []

```

Basic idea:

这道题和 513 很像，甚至代码只需要稍微修改一下就可以过

Python 的 BFS 解法如下：

```Python

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        
        res = []
        
        if root is None:
            return res
        
        queue = deque([root])
        
        while queue:
            length = len(queue)
            maxValue = float('-inf')
            for index in range(length):
                curr = queue.popleft()
                if curr.left is not None:
                    queue.append(curr.left)
                if curr.right is not None:
                    queue.append(curr.right)
                
                maxValue = max(maxValue,curr.val)
            res.append(maxValue)
        
        return res

```

---

Python 的 DFS 解法如下：

```Python

class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        
        res = []
        
        self.dfs(root,0,res)
        
        return res
    
    def dfs(self,root,level,res):
        
        if root is None:
            return
        
        if level==len(res):
            res.append(root.val)
        else:
            res[level] = max(res[level],root.val)
        
        self.dfs(root.left,level+1,res)
        self.dfs(root.right,level+1,res)

```