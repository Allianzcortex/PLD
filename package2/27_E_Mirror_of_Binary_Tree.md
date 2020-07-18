Classic Problem.

Iterative & Recursive solutions.

```Java

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        while(!s.isEmpty()) {
            TreeNode currentNode = s.pop();
            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;
            if(currentNode.left!=null) s.add(currentNode.left);
            if(currentNode.right!=null) s.add(currentNode.right);
        }
        return root;
    }
}


```