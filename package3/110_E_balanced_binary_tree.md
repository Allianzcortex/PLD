
Two Java Solution

1. bottom-up : O(N^2)

2. top-down : O(N)

---

For solution1

Many duplicate calculations

```Java

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return Math.abs(getHeight(root.left)-getHeight(root.right))<=1 && isBalanced(root.left)
        && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if(root==null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}

```

For Solution2

multiple passes : 

```Java

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return height(root)!=-1;
        
    }
    
    public int height(TreeNode root) {
        if(root==null)
            return 0;
        int leftHeight=height(root.left);
        if(leftHeight==-1)
            return -1;
        int rightHeight=height(root.right);
        if(rightHeight==-1)
            return -1;
        
        return Math.abs(leftHeight-rightHeight)>1?-1:Math.max(leftHeight,rightHeight)+1;
    }
}

```