
DFS: Solution 1

from top to down,compare grandChildren

```Java

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null)
            return 0;
        int sum = 0;
        if(root.val%2==0) {
            if(root.left!=null) {
                sum+=root.left.left==null?0:root.left.left.val;
                sum+=root.left.right==null?0:root.left.right.val;
            }
            if(root.right!=null) {
                sum+=root.right.left==null?0:root.right.left.val;
                sum+=root.right.right==null?0:root.right.right.val;
            }
        }
        
        return sum+sumEvenGrandparent(root.left)+sumEvenGrandparent(root.right);
    }
}

```

Another solution will be from bottom to up,compare grandParent Value

TODO : Need to check this answer again later

```Java

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root,1,1);
    }
    
    public int helper(TreeNode root,int parentValue,int grandParentValue) {
        if(root==null)
            return 0;
        return helper(root.left,root.val,parentValue)+helper(root.right,root.val,parentValue)+(grandParentValue%2==0?root.val:0);
    }
}

```