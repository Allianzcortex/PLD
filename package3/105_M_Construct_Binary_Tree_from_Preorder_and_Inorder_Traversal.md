
Problem description :

```
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

```

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

---

For Python solution , using `slice` will be simpler :

```Python


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:

        if not inorder:
            return None
        
        if len(inorder)==1:
            return TreeNode(inorder[0])
        
        target = preorder[0]
        root = TreeNode(target)
        
        index = inorder.index(target) # todo : may optimize it
        
        root.left = self.buildTree(preorder[1:index+1], inorder[:index])
        root.right = self.buildTree(preorder[index+1:], inorder[index+1:])
        
        return root

```

当然我们也可以重新用 index 来计算，显然代码比 Java 代码好看多了：

```Python


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        relations = {}
        
        for index,val in enumerate(inorder):
            relations[val] = index
        
        return self.generateNode(preorder,0,len(preorder)-1,inorder,0,len(inorder)-1,relations)
    
    
    def generateNode(self,preorder,left_p,right_p,inorder,left_in,right_in,relations):
       
        if  left_in > right_in:
            return None
        
        # not very necessary LOL
        # if left_in == right_in:
        #     return TreeNode(inorder[left_in])
        
        target = preorder[left_p]
        index = relations[target] # length of left part will be : index-left_in
        left_length = index-left_in
        
        root = TreeNode(target)
        
        root.left =self.generateNode(preorder,left_p+1,left_p+left_length,inorder,left_in,index-1,relations) 
        
        root.right = self.generateNode(preorder,left_p+left_length+1,right_p,inorder,index+1,right_in,relations)
        
        return root

```