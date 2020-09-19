
Java Solution:

There are 2 kinds of solutions :

1. Traverse all the leaves and get the result , them compare them.

```Java
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        traverse(s1,root1);
        traverse(s2,root2);
        return s1.toString().equals(s2.toString());
     
    }
    
    public void traverse(StringBuilder s,TreeNode root) {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            s.append(root.val+" ");
        traverse(s,root.left);
        traverse(s,root.right);
    }
}

```

2. Compare one by one,we need to use Stack to achieve it.

This is really an elegant solution.

```Java

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        
        while(!s1.isEmpty() && !s2.isEmpty()) {
            if(traverse(s1)!=traverse(s2))
                return false;
        }
        
        return s1.isEmpty() && s2.isEmpty();
    }
    
    public int traverse(Stack<TreeNode> s) {
        while(true) {
        TreeNode cur = s.pop();
        if(cur.right!=null)
            s.push(cur.right);
        if(cur.left!=null)
            s.push(cur.left);
        if(cur.left==null && cur.right==null)
            return cur.val;
        }    
    }
}


```