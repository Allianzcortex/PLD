
There should be no difficulty at all......

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