
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
        if (preorder==null || preorder.length==0) {
            return null;
        }
        
        Map<Integer,Integer> orders = new HashMap<>();
        for(int i=0;i<preorder.length;i++) {
            orders.put(inorder[i],i);
        }
        
        return buildTreeNode(preorder,orders,0,preorder.length-1,0,inorder.length-1);
    }
    
    private TreeNode buildTreeNode(int[] preorder,Map<Integer,Integer> orders,int preLeft,int preRight,int inLeft,int inRight) {
        if(preLeft>preRight) {
            return null;
        }
        if(preLeft==preRight) {
            return new TreeNode(preorder[preLeft]);
        }
        
        // firstly, we find the 1st number of preorder
        int rootVal = preorder[preLeft];
        int rootIndex = orders.get(rootVal);
        int leftLength = rootIndex-inLeft;
        // 这里关键是得到要分割的左半边的长度，然后就以此来计算出：
        // a. 对树的左半边 root.left 来说：
        // a.1 对 preorder，边界是 [preLeft+1, preLeft+leftLength]
        // b. 对树的右半边 root.right 来说：
        // b.1 对 preorder，边界是 [preLeft+leftLength+1,preRight]
        // 而对 Inorder 部分，它则主要和 rootIndex 有关
        // a.2 对 root.left 的 inorder, 边界是 [inLeft,rootIndex-1]
        // b.2 对 root.right 的 inorder，边界是 [rootIndex+1,inRight]

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeNode(preorder,orders,preLeft+1,preLeft+leftLength,inLeft,rootIndex-1);
        root.right = buildTreeNode(preorder,orders,preLeft+leftLength+1,preRight,rootIndex+1,inRight);
        
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