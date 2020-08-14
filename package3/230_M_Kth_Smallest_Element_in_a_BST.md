
There are 2 solutions :

In-order : `left middle right` will order the value from small to big

1. Iterate through the BST(with Stack)
This is the solution I use


```Java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // left middle right
        Stack<TreeNode> s = new Stack<>();
        int index = 0;
        while(!s.isEmpty() || root!=null) {
            while(root!=null) {
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            index+=1;
            if(index==k)
                return root.val;
            else {
                root = root.right;
            }
        }
        
        return -1;
    }
}

```

2. DFS iterate through the BST(recursively)

It will require us to use global variables

```Java
class Solution {
    private int counter = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
         solve(root,k);
         return res;
    }
    
    public void solve(TreeNode root,int k) {
        if(root.left!=null)
            solve(root.left,k);
        counter+=1;
        if(counter==k) {
            res = root.val;
            return;
        }
        if(root.right!=null)
            solve(root.right,k);
        
    }
}

```

---

Python Solution

