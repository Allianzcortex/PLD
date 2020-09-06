Java Solution :

1. Recursive

```Java
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        int sum = 0;
        
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            if(cur==null)
                continue;
            if(cur.val<L)
                s.push(cur.right);
            else if(cur.val>R)
                s.push(cur.left);
            else {
                sum+=cur.val;
                s.push(cur.left);
                s.push(cur.right);
            }
        }
        
        return sum;
    }
}

```

2. Iterative

```Java

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur==null)
                continue;
            if(cur.val==val)
                return cur;
            else if(cur.val<val) {
                stack.push(cur.right);
            } else {
                stack.push(cur.left);
            }
        }
        
        return null;
    }
}

```

And a simple iterative solution:

```Java

public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val<root.val? root.left:root.right;
        }
        return root;
    }

```