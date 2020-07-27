
```Java

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length!=postorder.length)
            return null;
        Map<Integer,Integer> mark=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            mark.put(inorder[i],i);
        }
        return buildTreeFromInPost(inorder,0,inorder.length-1,postorder,
                                  0,postorder.length-1,mark);
    }
    
    public TreeNode buildTreeFromInPost(int[] inorder,int instart,int inend,int[] postorder,int poststart,int postend,Map<Integer,Integer> mark) {
        if(instart>inend || poststart>postend)
            return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int index = mark.get(postorder[postend]);
        root.left = buildTreeFromInPost(inorder,instart,index-1,postorder,poststart,poststart+(index-instart-1),mark);
        root.right = buildTreeFromInPost(inorder,index+1,inend,postorder,poststart+(index-instart),postend-1,mark);
        return root;
    }
}

```