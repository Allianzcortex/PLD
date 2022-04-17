
Problem description:

```

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:

Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105
 

Follow up: Could you solve it with time complexity O(height of tree)?

```

Basic idea:

自己一开始的解法还有用 combineTrees 的，真是太复杂了...

对应的 Java 解法如下：

这里的关键部分是找到一个 `root`，root.val=key，并且 root 同时有
left 和 right subtree，接下来如何删除这个 root :

解法也很巧妙，找到 root.right 然后一直找左数组，则找到的就是 root.right 的最小值(记为 rightSmallest)，之后把 root.left 赋值给 rightSmallest.left，再返回 root.right;

```Java

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
     
        if(root==null) {
            return null;
        }
        
        if(root.val<key) {
            root.right = deleteNode(root.right,key);
        } else if(root.val>key) {
            root.left = deleteNode(root.left,key);
        } else {
           if(root.right==null)
                 return root.left;
           if(root.left==null) 
                 return root.right;
             // it has both left & right
            TreeNode rightSmallest = root.right;
            while(rightSmallest.left!=null)
                rightSmallest = rightSmallest.left;
            rightSmallest.left = root.left;
            return root.right;
         }   
        
        return root;
        }
    }

```

Python 解法如下：

```Python

class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        
        if not root:
            return None

        if root.val<key:
            root.right = self.deleteNode(root.right,key)
        elif root.val>key:
            root.left = self.deleteNode(root.left,key)
        else:
            if not root.left:
                return root.right
            if not root.right:
                return root.left
            
            smallest_right = root.right
            while smallest_right.left:
                smallest_right = smallest_right.left
            
            smallest_right.left = root.left
            return root.right
        
        return root

```