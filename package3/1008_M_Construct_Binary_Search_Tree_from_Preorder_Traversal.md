
Very classic problem. Re-build the tree like binary search

This is my solution

```Java

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder==null || preorder.length==0)
            return null;
        return helper(preorder,0,preorder.length-1);
    }
    
    public TreeNode helper(int[] preorder,int left,int right) {
        if(left>right)
            return null;
        if(left==right)
            return new TreeNode(preorder[left]);
        // build root 
        TreeNode root = new TreeNode(preorder[left]);
        // build left and right
        int index=left+1;
        // ! ! ! take care,need to add index<=right precondition so no indexOutofBound
        while(index<=right && preorder[index]<preorder[left])
            index+=1;
        root.left = helper(preorder,left+1,index-1);
        root.right = helper(preorder,index,right);
        
        return root;
    }
}

```

TOOD : check discussions for other solutions & add python solution