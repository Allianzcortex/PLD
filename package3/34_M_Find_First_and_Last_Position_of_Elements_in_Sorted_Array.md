
Problem description:

```
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

```

Basic idea:

这是一道很经典的 `binary search` 题，其中 Python 的解法应该是优先记忆的

基本思路如下，套用模板，left=0 && right=len(nums)-1 , while(left<=right)
其中对 `nums[middle]==target` 的处理非常好，默认初始化 index==-1 然后
在发现 target 时再给予更新。the 1st 还可能在更左边，the last 还可能在最右边，依此类推

```Python

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        """
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]
        
        """
        
        if nums is None or len(nums)==0:
            return [-1,-1]
        
        return [self.findElement(nums,target,0),self.findElement(nums,target,1)]
    
    def findElement(self,nums:List[int],target:int,flag:int):
        # flag : flag=0 means its to find firstIndex
        #        flag=1 means its to find lastIndex
        left,right=0,len(nums)-1
        res = -1
        
        while left<=right:
            middle = left + (right-left)//2
            if (nums[middle]>target):
                right = middle -1
            elif (nums[middle]<target):
                left = middle + 1
            else:
                res = middle
                # for firstIndex,we try to find from the left of middle, so right = middle -1
                # for lastIndex,we try to find from the right of middle, so left = middle +1
                if flag==0:
                    right = middle-1
                else:
                    left = middle+1
        
        return res

```

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