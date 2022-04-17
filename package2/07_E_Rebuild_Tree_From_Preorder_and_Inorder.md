Problem Description:

```
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

```

Analysis:

Time Complexity : O(N) for we need to iterate the inorder array to build dict, and we will build
N nodes, each node will require O(1) time. So overall it will be O(N)

Space Complexity : O(N):Dict will use O(N) to build HashMap. And also for the tree: worst case is 
that the tree will be like a linked list then it will cost O(N) space : best case is that the tree
will always have left&right ndoes(complete binary tree) then it will cost O(logN) space.

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

Python Solution:

Solution 1, idea is like Java solution:

```Python

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        return self.helper(preorder,0,inorder,0,len(inorder)-1)
    
    def helper(self,preorder,preroot:int,inorder,left,right):
        if left > right:
            return None
        if left == right:
            return TreeNode(preorder[preroot])
        middle_val = preorder[preroot]
        root = TreeNode(middle_val)
        index = inorder.index(middle_val)
        root.left = self.helper(preorder,preroot+1,inorder,left,index-1)
        root.right = self.helper(preorder,preroot+(index-left)+1,inorder,index+1,right)
        return root

```

Python solution 2 : using a dict to store the index

```Python

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        def helper(root_index,left,right):
            if left > right:
                return None
            root = TreeNode(preorder[root_index])
            index = dic.get(preorder[root_index])
            root.left = helper(root_index+1,left,index-1)
            root.right = helper(root_index+index-left+1,index+1,right)
            return root 
        
        dic = {}
        for index,value in enumerate(inorder):
            dic[value] = index
        return helper(0,0,len(preorder)-1)

```