

```Java

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // prevent NPE when t1 and t2 are both null / is either null
        if(t1==null && t2==null)
            return null;
        if(t1==null || t2==null)
            return t1==null?t2:t1;
        TreeNode temp = new TreeNode(t1.val+t2.val);
        temp.left = mergeTrees(t1.left,t2.left);
        temp.right = mergeTrees(t1.right,t2.right);
        return temp;
    }
}

```

TODO : add iterative solution 

TODO : add python solution