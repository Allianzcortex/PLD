

Problem Description :

```

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.

```

Below is Java Solution :

```Java
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        return findMiddleNode(nums,0,nums.length-1);
    }
    
    public TreeNode findMiddleNode(int[] nums,int left,int right){
        if(left>right)
            return null;
        int middle=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[middle]);
        root.left=findMiddleNode(nums,left,middle-1);
        root.right=findMiddleNode(nums,middle+1,right);
        return root;
    }
}

```

---

Next is Python Solution:

```Python

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if nums is None or len(nums)==0:
            return None
        
        if len(nums)==1:
            return TreeNode(nums[0])
        
        middle = len(nums) // 2
        root = TreeNode(nums[middle])
        root.left = self.sortedArrayToBST(nums[:middle])
        root.right = self.sortedArrayToBST(nums[middle+1:])
        
        return root

```