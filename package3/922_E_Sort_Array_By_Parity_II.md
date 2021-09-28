
Problem description:

```

Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

 

Example 1:

Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
Example 2:

Input: nums = [2,3]
Output: [2,3]
 

Constraints:

2 <= nums.length <= 2 * 104
nums.length is even.
Half of the integers in nums are even.
0 <= nums[i] <= 1000
 

Follow Up: Could you solve it in-place?

```

Basic idea : 这道题就是 easy 难度，用 two pointer 分别指向
奇数 index 和 偶数 index

Python 解法如下：

```Python

class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        
        oddP,evenP = 1,0
        
        while oddP<len(nums) and evenP<len(nums):
            while oddP<len(nums) and nums[oddP]%2==1:
                oddP += 2
            while evenP<len(nums) and nums[evenP]%2==0:
                evenP += 2
            
            if oddP<len(nums) and evenP<len(nums):
                nums[oddP],nums[evenP] = nums[evenP],nums[oddP]
                oddP += 2
                evenP += 2
        
        return nums

```