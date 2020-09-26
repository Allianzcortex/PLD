
Java Solution :

```Java

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        // 注意是一个 solvePath 和两个 pathSum 方法，这样可以解决 [1,null,2,null,3,null,4,null,5],3 的情况
        // 1-2 和 3 都满足和为 3 的情况
        return solvePath(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    
    public int solvePath(TreeNode root,int sum) {
        int res=0;
        if(root==null)
            return res;
        if(root.val==sum)
            res+=1;

        return res+solvePath(root.left,sum-root.val)+solvePath(root.right,sum-root.val);
    }
}


```

TODO : Add iterative and Python solution