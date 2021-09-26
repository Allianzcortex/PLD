
Problem description:

```

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1

```

Basic idea :

这道题的思路是这样的：

1) Diameter 是由 leftLength + rightLength 合并而成

2) 但每个 subtree 的 LeftLength 是由 max(sub.LeftLength,sub.sub.rightLength) 来组成

所以对应的 Python 解法如下：

```Python

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        
        if root is None:
            return 0
        
        self.maxLength = 0
        self.dfs(root)
        
        return self.maxLength
    
    def dfs(self,root):
        
        if root is None:
            return 0
        leftLength = self.dfs(root.left)
        rightLength = self.dfs(root.right)
        
        if leftLength + rightLength > self.maxLength:
            self.maxLength = leftLength + rightLength
        
        return max(leftLength,rightLength)+1

```

对应 Java 解法如下：

```Java

class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
      solve(root,root);
        return max;
    }
    
    public int solve(TreeNode root,TreeNode target) {
        if(root==null)
            return 0;
        int leftLength=solve(root.left,target);
        int rightLength=solve(root.right,target);
        max = Math.max(max,leftLength+rightLength);
        return Math.max(leftLength,rightLength)+1;
    }
}

```