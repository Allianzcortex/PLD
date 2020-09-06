
Two Solutions:

Java Solution

1. Recursive :

```Java

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null)
            return 0;
        if(root.val<L)
            return rangeSumBST(root.right,L,R);
        if(root.val>R)
            return rangeSumBST(root.left,L,R);
        return root.val+rangeSumBST(root.left,L,R) + rangeSumBST(root.right,L,R);
    }
}

```

2. Iterative Solution,with Stack:

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

---

TODO : add Python Implementation

