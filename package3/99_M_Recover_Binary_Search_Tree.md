
Problem description:

```

You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 

Constraints:

The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1
 

Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?

```

Basic idea:

首先先上自己 AC 的解法，还可以诶，虽然不是最优的，但考虑到一次就想到了，在面试中
也足够了

基本思路就是中序遍历，然后比较得到的 val array:
计算有多少处发生了 `val[i]>val[i+1]`

1. 如果只有一处，说明相邻的节点发生交换(相邻的意思是在 preorder 上相邻，而不是说节点上相邻)

2. 如果有两处，说明是非相邻的节点发生交换

比如没有交换前是 `[1,2,3,4,5,6]`

1. 两个邻近交换，变成 `[2,1,3,4,5,6]`，发现 `val[i]>val[i+1]` 的场景只有一次，就是 `2>1`

2. 非两个邻近交换，假如变成 `[1,5,3,4,2,6]`，发现 `val[i]>val[i+1]` 的场景会有两次，分别是
`5>3` 和 `4>2`。选择第一次发生的最左边部分和第二次发生的最右边部分，就可以找到发生交换的两个节点

自己一开始 AC 的解法就很直观，用中序遍历找出所有的异常：

```Python

class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        match = {} # val -> node
        values = []
        self.traverse(root,match,values)
        
        pivots = []
        for i in range(len(values)-1):
            if values[i]>values[i+1]:
                pivots.extend([values[i],values[i+1]])
        
        # 2 cases : a. two adjacent nodes are swapped -> find 1 place that val[i]>val[i+1]
        # b. two nodes that are not adjacent are swapped -> find 2 places that val[i]>val[i+1]
        if(len(pivots)==2):
            val1,val2 = pivots
        else:
            val1,val2 = pivots[0],pivots[-1]
        
        match[val1].val = val2
        match[val2].val = val1
    
    
    def traverse(self,root,match,values):
        
        if not root:
            return
        self.traverse(root.left,match,values)
        values.append(root.val)
        match[root.val] = root
        self.traverse(root.right,match,values)

```

但优化的方法也很明显，就是在遍历过程中就找出异常，方法如下：

```Python

class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        
        self.node1,self.node2 = None,None
        self.prev = None
        
        self.traverse(root)
        
        self.node1.val,self.node2.val = self.node2.val,self.node1.val
    
    def traverse(self,root):
        
        if not root:
            return
        
        self.traverse(root.left)
        if self.prev and root.val<self.prev.val:
            if not self.node1:
                # we find an exception firstly
                self.node1,self.node2 = self.prev,root
            else:
                # we find an exception the 2nd time, only update the 2nd node
                self.node2 = root
        
        self.prev = root
        self.traverse(root.right)

```

#### TODO:

这道题是一道很好地练习 iterative traverse 的方法
需要后续再做一次