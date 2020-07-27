
Solution : Use `HashMap` to store the pivot index.

```Java

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length!=inorder.length)
            return null;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return traverse(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    
    public TreeNode traverse(int[] preorder,int preLeft,int preRight,int[] inorder,int inLeft,int inRight,Map<Integer,Integer> map) {
        if(preLeft>preRight || inLeft>inRight)
            return null;
        int index=map.get(preorder[preLeft]);
        TreeNode root=new TreeNode(preorder[preLeft]);
        root.left = traverse(preorder,preLeft+1,preLeft+(index-inLeft),inorder,inLeft,index-1,map);
        root.right = traverse(preorder,preLeft+(index-inLeft+1),preRight,inorder,index+1,inRight,map);
        return root;
    }
}


```