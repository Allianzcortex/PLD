
This problem is duplicated with 530.

In-order Traversal 


```Java

class Solution {
    
     TreeNode pre=null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
     
        if(root==null)
            return 0;
        minDiffInBST(root.left);
        if(pre!=null) {
            min = Math.min(min,root.val-pre.val);
        }
        pre = root;
        
        minDiffInBST(root.right);       
        return min;
        
    }
}

```
TODO : need to check more absolutely.......e.g. iterative solution and Python solution