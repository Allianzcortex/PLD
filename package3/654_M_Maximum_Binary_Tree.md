
Simple DFS + divid&conquer solution

```Java

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null || nums.length==0)
            return null;
        
        return helper(nums,0,nums.length-1);
    }
    
    public TreeNode helper(int[] nums,int left,int right) {
        if(left>right)
            return null;
        int indexMax = left;
        for(int i=left+1;i<=right;i++) {
            if(nums[i]>nums[indexMax])
                indexMax = i;
        }
        
        TreeNode root = new TreeNode(nums[indexMax]);
        root.left = helper(nums,left,indexMax-1);
        root.right = helper(nums,indexMax+1,right);
        
        return root;
    }
}

```



Initially I came up with the next solution....oh my gosh,really there
is no need for quickselect

#### Wrong Solution

```Java
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null || nums.length==0)
            return null;
        
        return helper(nums,0,nums.length-1);
    }
    
    public TreeNode helper(int[] nums,int left,int right) {
        if(left>right)
            return null;
        if(left==right)
            return new TreeNode(nums[left]);
        int pivot = quickSelect(nums,left,right);
        TreeNode root = new TreeNode(nums[pivot]);
        root.left = helper(nums,left,pivot-1);
        root.right = helper(nums,pivot+1,right);
        return root;
    }
    
    public int quickSelect(int[] nums,int left,int right) {
        int pivot = nums[left];
        while(left<right) {
            while(nums[right]>=pivot && left<right)
                right-=1;
            nums[left]=nums[right];
            while(nums[left]<=pivot && left<right)
                left+=1;
            nums[right] = nums[left];
            swap(nums,left,right);
        }
        
        nums[left] = pivot;
        return left;
    }
    
    public void swap(int[] nums,int left,int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

```


TODO : check discussions & add Python solution