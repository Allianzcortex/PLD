
No idea why this is a medium problem....recursive solution is pretty 
straight-forward

Java Solution :

```Java

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // original == null,then cloned will be null,then
        // it will enter into the rightTree part
        if(original == target || original==null)
            return cloned;

        TreeNode leftRes = getTargetCopy(original.left,cloned.left,target);
        if(leftRes != null)
            return leftRes;
        return getTargetCopy(original.right,cloned.right,target);
    }
}

```

---

Python Solution :

