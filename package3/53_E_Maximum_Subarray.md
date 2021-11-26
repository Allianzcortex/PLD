
Problem description:

```

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

```

Basic idea:

这道题思路还是很明确的，要求最大值，那么用 dp[i] 表示：
`maximum value of contigues array which ends with ith number`

只要前一个 dp[i-1] 大于零，就符合要求，加上结果

Java 解法如下：

```Java

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        
        int[] dp=new int[nums.length];
        dp[0] = nums[0];
        int maxRes = dp[0];
        for(int i=1;i<nums.length;i++) {
            if(dp[i-1]>0)
                dp[i]=dp[i-1]+nums[i];
            else
                dp[i]=nums[i];
            maxRes=Math.max(dp[i],maxRes);
        }
        
        return maxRes;
    }
}

```

Python 解法如下：

```Python

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp=[0]*len(nums)
        dp[0]=nums[0]
        for i in range(1,len(nums)):
            dp[i] = max(dp[i-1]+nums[i], nums[i])
        return max(dp)
        

```

Golang 解法如下：

```Go
func maxSubArray(nums []int) int {
    length:=len(nums)
    
    dp:=make([]int,length)
    dp[0] = nums[0] // dp[i] means the maximum value of contiguous array , and this array
    // ends with ith number
    res := nums[0]
    
    for i:=1;i<length;i++ {
        dp[i] = max(nums[i],nums[i]+dp[i-1])
        res = max(res,dp[i])
    }
    
    return res
    
}


func max(a,b int) int {
    if(a>b) {
        return a
    }
    
    return b
}

```