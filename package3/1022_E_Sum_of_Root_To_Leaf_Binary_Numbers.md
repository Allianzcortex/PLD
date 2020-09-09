
My DFS Java implementation

While using `Integer.parseInt(str,2)` is a viable solution, its not the 
most effective one ,we can use `val = prev*2+val` to get it.

e.g. `101= a. a. 0*2+1=1 b.1*2+0=2 c.2*2+1=5`

```Java

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        if(root==null)
            return 0;
        String path = String.valueOf(root.val);
        return dfs(root,path);
    }
    
    public int dfs(TreeNode root,String path) {
        // reach to the end
        if(root.left==null && root.right==null) {
            return Integer.parseInt(path,2);
        }
        
        int sum = 0;
        if(root.left!=null) {
            sum+=dfs(root.left,path+String.valueOf(root.left.val));
        }
        if(root.right!=null) {
            sum+=dfs(root.right,path+String.valueOf(root.right.val));
        }
        
        return sum;
        
    }
}

```

---


This will be a effective way :

```Java

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }
    
    public int dfs(TreeNode root,int prevSum) {
        if(root==null)
            return 0;
        int val = prevSum*2+root.val;
        
        return (root.left==null && root.right==null)? val : dfs(root.left,val)+dfs(root.right,val);
    }
}


```