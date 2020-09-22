
Java Solution

To find the 1st index :  `int mid = left + (right-left)/2`
to find the last index : `int mid = left + (right-left+1)/2`

```Java

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return new int[]{-1,-1};
        
        int len = nums.length;
        int firstIndex = findFirstIndex(nums,0,len-1,target);
        if(firstIndex==-1)
            return new int[]{-1,-1};
        
        int lastIndex = findLastIndex(nums,0,len-1,target);
        return new int[]{firstIndex,lastIndex};
    }
    
    public int findFirstIndex(int[] nums,int left,int right,int target) {
        while(left<right) {
            int mid = left + (right-left)/2;
            if(nums[mid]==target) {
                right = mid;
            } else if(nums[mid]>target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return nums[left]==target?left:-1;
    }
    
    public int findLastIndex(int[] nums,int left,int right,int target) {
        while(left<right) {
            int mid = left + (right-left+1)/2;
            if(nums[mid]==target) {
                left = mid;
            } else if(nums[mid]>target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}

```

TODO : have a more solid understanding about binary search

https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/