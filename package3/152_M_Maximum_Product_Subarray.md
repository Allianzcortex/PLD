
Problem description :

```

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

```

Idea : 基本思路

因为要考虑 + / - 数，前面的最小值 * 负数 就是最大值，前面的最大值 * 正数 就是最大值
所以用两个数组来分别存储最大最小值

同时在比较的时候加上 `nums[i]` 是为了考虑当 `nums[i]` 为 0 时的情况，比如 `[0,2]`

当然在空间复杂度上不用保存一整个 array，只用 2 个变量存储 prev_max 和 prev_min 就好了

Python Solution :


```Python

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        max_value = [-1]*len(nums)
        min_value = [-1]*len(nums)
        
        max_value[0] = min_value[0] = res = nums[0]
        
        for i in range(1,len(nums)):
            val1 = max_value[i-1]*nums[i]
            val2 = min_value[i-1]*nums[i]
            max_value[i] = max(val1,val2,nums[i])
            if max_value[i] > res:
                res = max_value[i]
            min_value[i] = min(val1,val2,nums[i])
        
        return res

```

下面是 Golang 解法：

```Golang

func maxProduct(nums []int) int {
    
    length:=len(nums)
    
    prevMax,prevMin,res:= nums[0],nums[0],nums[0]
    
    for i:=1;i<length;i++ {
        
        val1:=prevMax*nums[i]
        val2:=prevMin*nums[i]
        
        prevMax = max(max(val1,val2),nums[i])
        prevMin = min(min(val1,val2),nums[i])
        
        if(prevMax>res) {
            res = prevMax
        }
    }
    
    return res
}

func max(a,b int) int {
    if(a>b) {
        return a
    }
    
    return b
}

func min(a,b int) int {
    if(a<b) {
        return a
    }
    
    return b
}

```

Below is Java solution:

DP Solution, using 2 arrays to store the value.

```Java

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        int maxValue;
        dpMax[0]=dpMin[0]=maxValue=nums[0];
        
        for(int i=1;i<len;i++) {
            dpMax[i]=Math.max(nums[i],Math.max(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]));
            if(dpMax[i]>maxValue)
                maxValue = dpMax[i];
            dpMin[i] = Math.min(nums[i],Math.min(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]));
        }
        
        return maxValue;
    }
}

```