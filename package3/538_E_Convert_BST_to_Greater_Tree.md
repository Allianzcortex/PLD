
reverse inorder traverse to generate `big->middle->small` sequence

```Java

class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    
    public void traverse(TreeNode root) {
        if(root==null)
            return ;
        traverse(root.right);
        root.val = sum + root.val;
        sum = root.val;
        traverse(root.left);
    }
}

```

TODO : check discussions for more solutions and add python solution