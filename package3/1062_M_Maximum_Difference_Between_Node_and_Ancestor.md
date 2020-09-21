

I make this problem too complex...

This DFS solution seems straight-forward but will require you to take
a lot of time to think about it.

```Java

class Solution {
    
    public int maxAncestorDiff(TreeNode root) {
        if(root==null)
            return 0;
        return helper(root,root.val,root.val);
    }
    
    public int helper(TreeNode root,int minValue,int maxValue) {
        if(root==null)
            return maxValue - minValue;
        maxValue = Math.max(root.val,maxValue);
        minValue = Math.min(root.val,minValue);
        
        return Math.max(helper(root.left,minValue,maxValue),helper(root.right,minValue,maxValue));
    }
}

```

---

TODO : Add (possible) iterative solution / Python Solution