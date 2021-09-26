
Problem description:

```

Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7

```

Basic idea:

这道题我的思路就是用 BFS 来层层遍历：

Python 代码如下：

```Python

class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        
        leftMost = -1
        
        queue = deque([root])
        
        while queue:
            length = len(queue)
            
            for index in range(length):
                curr = queue.popleft()
                if curr.left is not None:
                    queue.append(curr.left)
                if curr.right is not None:
                    queue.append(curr.right)
                
                if index==0:
                    leftMost = curr.val
        
        return leftMost

```

对应的 Java 解法如下：

```Java

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int leftMost=0;
        if(root==null)
            return leftMost;
        
        Queue<TreeNode> q =new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(i==0)
                    leftMost=curr.val;
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            } 
        }
        
        return leftMost;
    }
}

```
---

这道题当然还有 DFS 解法，从左向右遍历，每当有 depth 更新的话就设立新的值：

```Python

class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        
        self.depth,self.leftMostVal = 0,-1
        
        self.dfs(root,1)
        
        return self.leftMostVal
    
    def dfs(self,root,level):
        
        if root is None:
            return
        
        if level>self.depth:
            self.leftMostVal = root.val
            self.depth = level
        
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)


```