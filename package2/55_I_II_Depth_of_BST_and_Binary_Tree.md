
Problem I :

```Java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}

```

Problem II :

```Java
class Solution {

    // TODO use HashMap/Stack/Queue iterative solution
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return Math.abs(depth(root.left)-depth(root.right))<=1 && isBalanced(root.left) 
        && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if(root==null)
            return 0;
        // if(map.containsKey(root))
            // return map.get(root);
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}

```