```Java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length)
            return null;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return solve(0,0,inorder.length-1,preorder,map);
    }

    public TreeNode solve(int preRoot,int inLeft,int inRight,int[] preorder,Map<Integer,Integer> map) {
        if(inLeft>inRight)
            return null;
        int nodeValue = preorder[preRoot];
        int index = map.get(nodeValue);
        TreeNode root=new TreeNode(nodeValue);
        root.left = solve(preRoot+1,inLeft,index-1,preorder,map);
        root.right= solve(preRoot+index-inLeft+1,index+1,inRight,preorder,map);
        return root;
    }
}

```