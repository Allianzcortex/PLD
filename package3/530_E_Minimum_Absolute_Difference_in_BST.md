
Use BST to find every two adjacent difference.

```Java

class Solution {
    TreeNode pre=null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)
            return 0;
        getMinimumDifference(root.left);
        if(pre!=null) {
            min = Math.min(min,root.val-pre.val);
        }
        pre = root;
        
        getMinimumDifference(root.right);       
        return min;
            
    }
}

```

There should be other good ways.