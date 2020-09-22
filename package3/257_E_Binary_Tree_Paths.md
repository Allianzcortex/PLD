
Classic DFS way to solve the problem

```Java

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        traverse(res,root,"");
        return res;
        
    }
    
    public void traverse(List<String> res,TreeNode root,String path){
        System.out.println(path);
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            path+=root.val;
            res.add(path);
            return;
        }
         path+=root.val;
        path+="->";
       
        traverse(res,root.left,path);
        traverse(res,root.right,path);
        
    }
}


```