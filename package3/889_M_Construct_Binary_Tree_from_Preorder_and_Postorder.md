
Java Solution. Finish it the 1st time ^^

Idea should be pretty straight-forward.

Yet still need to check discussions for other solutions and Python solution

```Java

class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length==0)
            return null;
        
        return helper(pre,0,pre.length-1,post,0,post.length-1);
    }
    
    public TreeNode helper(int[] pre,int l1,int r1,int[] post,int l2,int r2) {
        if(l1>r1 || l2>r2)
            return null;
        
        TreeNode root = new TreeNode(pre[l1]);
        int index=l1+1;
        if(index>r1)
            return root;
        for(int i=l2;i<=r2-1;i++) {
            if(post[i]==pre[index]) {
                index = i;
                break;
            }
        }
        
        root.left = helper(pre,l1+1,l1+1+index-l2,post,l2,index);
        root.right = helper(pre,l1+1+index-l2+1,r1,post,index+1,r2-1);
        return root;
        
    }
}

```