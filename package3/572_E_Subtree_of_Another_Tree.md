
Problem description:

```
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

 

Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104

```

Basic idea:

这道题是很典型的 tree 题：

1. 注意是首先判断 `self.isTreeEqual(root,subRoot)`

2. 然后是 `self.isSubtree(root.left,subRoot) or self.isSubtree(root.right,subRoot)`

对应的 Python 代码如下：

```Python

class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        
        if not root or not subRoot:
            return False
        
        return self.isTreeEqual(root,subRoot) or self.isSubtree(root.left,subRoot) or self.isSubtree(root.right,subRoot)
        
    
    def isTreeEqual(self,node1,node2):
        if not node1 and not node2:
            return True
        
        if not node1 or not node2:
            return False
        
        if node1.val==node2.val and self.isTreeEqual(node1.left,node2.left) and self.isTreeEqual(node1.right,node2.right):
                return True

```

---

自己当时的 Java 代码如下：

```Java

class Solution {
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        return judge(s,t) ||(s.left!=null && isSubtree(s.left,t)) || (s.right!=null && isSubtree(s.right,t));
    }
    
    public boolean judge(TreeNode s,TreeNode t) {
         if(s==null && t==null)
            return true;
        if(s==null || t==null)
            return false;
        return s.val==t.val && judge(s.left,t.left) && judge(s.right,t.right);
        
    }
}

```