
This is one incomplete solution, absolutely not enough

```Java

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        return findDepth(root,x,1)==findDepth(root,y,1) && !isSibling(root,x,y);
    }
    
    public int findDepth(TreeNode root,int val,int depth) {
        if(root==null)
            return 0;
        if(root.val==val)
            return depth;
        return findDepth(root.left,val,depth+1) | findDepth(root.right,val,depth+1);
    }
    
    public boolean isSibling(TreeNode root,int x,int y) {
        if(root==null)
            return false;
        boolean isValid=false;
        if(root.left!=null && root.right!=null) {
            isValid = (root.left.val==x && root.right.val==y) || (root.left.val==y && root.right.val==x);
        }
        
        return isValid || isSibling(root.left,x,y) || isSibling(root.right,x,y);
    }
}

```

TODO : check discussion for more elegant dfs&bfs solution