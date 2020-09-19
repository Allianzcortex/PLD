
Ba

1. Recursive Solution :

#### Well,it just seems easy to understand,but revursive solution
is not so straight-forward

```Java

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        return traverse(root,null);
    }
    
    public TreeNode traverse(TreeNode root,TreeNode tail) {
        if(root==null)
            return tail;
        TreeNode res = traverse(root.left,root);
        root.left = null;
        root.right = traverse(root.right,tail);
        return res;
        
    }
}

```

2. Iterative Solution :

```Java
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(-1);
        TreeNode head = dummy;
        
        while(root!=null || !stack.isEmpty()) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            head.right = root;
            head = head.right;
            root = root.right;
            head.left = null;
        }
        
        return dummy.right;
    }
}

```