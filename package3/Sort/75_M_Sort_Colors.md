Classic sort problems
divide into 3 parts

```Java
class Solution {
    public void sortColors(int[] nums) {
        int low=0,high=nums.length-1;
        for(int i=0;i<=high;i++) {
            if(nums[i]==0){
                swap(nums,i,low++);
            } else if(nums[i]==2){
                swap(nums,i--,high--);
            } 
        }
    }
    
    public void swap(int[] nums,int left,int right) {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
```

// plus,we can also re-write it in while-loop