
Problem 1

```Java

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // solution 1 iterative:
        // if(p==null && q==null)
        //     return null;
        // if(p==null || q==null)
        //     return p==null?q:p;

        // while(root!=null) {
        //     if(root.val<p.val && root.val<q.val)
        //         root=root.right;
        //     else if(root.val>p.val && root.val>q.val)
        //         root = root.left;
        //     else
        //         return root;
        // }
        // return null;

        // solution2:recursive
        if(p==null && q==null)
            return null;
        if(p==null || q==null)
            return p==null?q:p;
        if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        else if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        else
            return root;
    }
}

```

---

Problem 2:

```Java

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q)
            return root;
        if(root==null)
            return null;
        TreeNode leftCommon = lowestCommonAncestor(root.left,p,q);
        TreeNode rightCommon = lowestCommonAncestor(root.right,p,q);
        if(leftCommon!=null && rightCommon!=null)
            return root;
        return leftCommon!=null?leftCommon:rightCommon;
    }
}


```