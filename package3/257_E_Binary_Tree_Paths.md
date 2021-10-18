
Problem description:

```
Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100

```

Basic idea:
很经典的 DFS

```Java

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        traverse(res,root,"");
        return res;
        
    }
    
    public void traverse(List<String> res,TreeNode root,String path){

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