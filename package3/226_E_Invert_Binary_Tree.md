
Recursive :

method 1 :

```Java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

```

method 2 :

```Java

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode left=root.left,right=root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}

```

TODO : will add iterative solution(with stack/queue) and python solution