
Problem description:

```

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]


Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Note:

All of the nodes’ values will be unique.
p and q are different and both values will exist in the BST.

```

For problem 235 : its to find LCA of `Binary Search Tree`
For problem 236 : its to find LCA of `Binary Tree`

They are different.

For 235,we use the attribute of BST : 

时间复杂度：O(H) = O(longN) 因为这是一个 BST
空间复杂度：O(H)

Python 解法如下：

```Python

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        
        if root.val<p.val and root.val<q.val:
            return self.lowestCommonAncestor(root.right,p,q)
        
        if root.val>p.val and root.val>q.val:
            return self.lowestCommonAncestor(root.left,p,q)
        
        return root

```

Java 解法如下：

```Java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        
        return root;
    }
}

```