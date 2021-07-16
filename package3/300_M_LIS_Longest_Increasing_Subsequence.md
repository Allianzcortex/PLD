
Problem Description : 

```

Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

```

The first one is DP solution which is very easy to understand but 
time complexity can be up to O(N^2)

Java Solution

```Java

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 1;
        for(int i=1;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    res = Math.max(dp[i],res);
                }
            }
        }
        return res;       
    }
}
```

Python Solution :

```Python

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1]*len(nums)
        
        res = 1
        
        for i,ch in enumerate(nums):
            for j in range(i):
                if nums[i]>nums[j]:
                    dp[i] = max(dp[i],dp[j]+1)
        
        return max(dp)

```

---

The second solution O(logN) is based on binary_search :

This is basic idea : https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation

we use a tails array to store the smallest tail of all increaing sequences with length i.

for example : nums = [4,5,6,3]

for length 1 , it can be [4]/[5]/[6]/[3] , so smallest tail is [3]
for length 2 , it can be [4,5]/[4,6]/[5,6],so smallest tail is [5]
for length 3 , it can be [4,5,6]         , so smallest tail is [6]

obviously for tail array it's an increasing part.

Each time when we meet a new number , we have 3 cases :

1. `num<tail[0]` , we need to update tail[0] to num
2. `num>tail[index]`, we need to update tail[index] to num
3. `num in the middle`, we need to use binary search to find index and update the tail[index] to num

So overall Python solution will be like :

```Python

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        
        tails = [0] * len(nums)
        tails[0] = nums[0]
        index = 0
        
        for i in range(len(nums)):
            num = nums[i]
            if(num<tails[0]):
                tails[0] = num
            elif (num>tails[index]):
                index += 1
                tails[index] = num
            else:
                middle_item = self.binary_search(tails,0,index,num)
                print(middle_item)
                tails[middle_item] = num

        return index + 1
    
    def binary_search(self, nums,left,right,target):
        
        while left<=right:
            middle = left + (right-left) // 2
            
            if(nums[middle]==target):
                return middle
            elif(nums[middle]>target):
                right = middle - 1
            else:
                left = middle + 1
        
        return left

```