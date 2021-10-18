
Problem description:

```
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104

```

Basic idea:

Python 第一种解法，自顶向下，列举出所有可能的情况

```Python
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        
        left_height = self.getHeight(root.left)
        right_height = self.getHeight(root.right)
        
        if abs(left_height-right_height)<=1 and self.isBalanced(root.left) and self.isBalanced(root.right):
            return True
        
    
    
    def getHeight(self,root):
        if root is None:
            return 0
        
        return 1+max(self.getHeight(root.left),self.getHeight(root.right))

```

Python 第二种解法，自底向上，如果发现一个 Node 是 invalid 就返回 -1，解法如下：

```Python

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        
        return self.getHeight(root)!=-1
    
    def getHeight(self,root):
        if root is None:
            return 0
        
        left_height = self.getHeight(root.left)
        if left_height == -1:
            return -1
        
        right_height = self.getHeight(root.right)
        if right_height == -1:
            return -1
        
        if abs(left_height-right_height)<=1:
            return max(left_height,right_height)+1
        else:
            return -1

```

Two Java Solution

1. bottom-up : O(N^2)

2. top-down : O(N)

---

For solution1

Many duplicate calculations

```Java

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return Math.abs(getHeight(root.left)-getHeight(root.right))<=1 && isBalanced(root.left)
        && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if(root==null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}

```

For Solution2

multiple passes : 

```Java

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return height(root)!=-1;
        
    }
    
    public int height(TreeNode root) {
        if(root==null)
            return 0;
        int leftHeight=height(root.left);
        if(leftHeight==-1)
            return -1;
        int rightHeight=height(root.right);
        if(rightHeight==-1)
            return -1;
        
        return Math.abs(leftHeight-rightHeight)>1?-1:Math.max(leftHeight,rightHeight)+1;
    }
}

```