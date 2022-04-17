
Problem description:

```
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1

```

---

Basic idea : 

这道题可以用异或操作来计算：

相异为 1，相同为 0

1^1=0 -> 0^2=2

Java 解法如下：

```Java

class Solution {
    public int singleNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int res=nums[0];
        for(int i=1;i<nums.length;i++)
            res=res^nums[i];
        
        return res;
    }
}

```

对应的 Python 解法如下：

```Python

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = nums[0]
        
        for val in nums[1:]:
            res ^= val
        
        return res

```