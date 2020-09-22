
For problem 235 : its to find LCA of `Binary Search Tree`
For problem 236 : its to find LCA of `Binary Tree`

They are different.

For 235,we use the attribute of BST : 

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