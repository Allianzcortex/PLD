
Problem description:

```
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:

Input: nums = [1,3,5,6], target = 0
Output: 0
Example 5:

Input: nums = [1], target = 0
Output: 0
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104

```

basic idea:

这是一道非常基本的二分搜索问题

Java 解法如下：

```Java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right) {
            int middle = left + (right-left)/2;
            if(nums[middle]==target){
                return middle;
            } else if(nums[middle]>target){
                right = middle-1;
            } else {
                left = middle+1;
            }
        }
        return left;
    }
}

```

Golang 解法如下：

```Golang

func searchInsert(nums []int, target int) int {
    
    left,right := 0,len(nums)-1
    
    for left<=right {
        middle := left + (right-left)/2
        
        if(nums[middle]==target) {
            return middle;
        } else if(nums[middle]<target) {
            left = middle + 1;
        } else {
            right = middle -1;
        }
    }
        
        return left;
}

```