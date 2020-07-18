
```Java

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return judge(root.left,root.right);
    }

    public boolean judge(TreeNode leftNode,TreeNode rightNode) {
        if(leftNode==null || rightNode==null)
            return leftNode==rightNode;
        return leftNode.val==rightNode.val && judge(leftNode.left,rightNode.right) &&
        judge(leftNode.right,rightNode.left);
    }   
}

```