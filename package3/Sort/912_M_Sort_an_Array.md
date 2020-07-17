Many ways to implement the basic sort function.

This is my quick-sort choice : 

```Java
class Solution {
    public int[] sortArray(int[] nums) {
        if(nums==null || nums.length==0)
            return new int[]{};
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    
    public void quickSort(int[] nums,int left,int right){
        if(left>=right)
            return;
        int pivot = findPivot(nums,left,right);
        quickSort(nums,left,pivot-1);
        quickSort(nums,pivot+1,right);
        
    }
    
    public int findPivot(int[] nums,int left,int right) {
        int pivot = nums[left];
        while(left<right) {
            while(left<right && nums[right]>=pivot)
                right-=1;
            nums[left]=nums[right];
            
            while(left<right && nums[left]<=pivot)
                left+=1;
            nums[right]=nums[left];
            swap(nums,left,right);
        }
        nums[left]=pivot;
        return left;
    }
    
    public void swap(int[] nums,int left,int right) {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}



```