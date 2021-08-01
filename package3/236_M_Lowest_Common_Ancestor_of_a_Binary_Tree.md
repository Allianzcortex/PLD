
Problem description:

```
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1

```

这是一道很有趣的题，以最简单的一种结构来理解：

```
    1
  /   \
 2     3
```

对 [1,2,3] 来说，首先如果把 root.left 代入为 root，那么就成为了：[2,2,3]
因为 2 == 2 ，所以返回 2，同理 [3,2,3] 就会因为 3 == 3 而返回 3。

因为 2 和 3 都存在，那么 1 就是 common ancestor。

以上是根据两个子树都分别在根节点的左右两边来计算。

如果两个子树都在根节点的左边或者两个子树都在根节点的右边，那么一定有一边为 None。

Python 代码如下：

```Python

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is p or root is q or root is None:
            return root
        
        left_root = self.lowestCommonAncestor(root.left,p,q)
        right_root = self.lowestCommonAncestor(root.right,p,q)
        
        if left_root is not None and right_root is not None:
            return root
        else:
            return left_root or right_root

```

Java 代码如下：

```Java

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root==p || root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null)
            return root;
        return left==null?right:left;
    }
}

```