
Java Solution

```Java
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return valid(root,null,null);
    }
    
    public boolean valid(TreeNode root,Integer minValue,Integer maxValue) {
        if(root==null)
            return true;
        if(minValue!=null && root.val<=minValue)
            return false;
        if(maxValue!=null && root.val>=maxValue)
            return false;
        return valid(root.left,minValue,root.val) && valid(root.right,root.val,maxValue);
    }
}

```

---

Python Solution

```Python

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.validate(root,None,None)
    
    def validate(self,root: TreeNode,min_value,max_value):
        if(root is None):
            return True
        # Must use is not None , if simplily use if(min_value and...)
        # it will fail the case when min_value is 0
        if(min_value is not None and root.val<=min_value):
            return False
        if(max_value is not None and root.val>=max_value):
            return False
        return self.validate(root.left,min_value,root.val) and self.validate(root.right,root.val,max_value)
    
```