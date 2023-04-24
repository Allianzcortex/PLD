
Problem description:

```
You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums.

 

Example 1:

Input: nums = [1,2,3,2]
Output: 4
Explanation: The unique elements are [1,3], and the sum is 4.
Example 2:

Input: nums = [1,1,1,1,1]
Output: 0
Explanation: There are no unique elements, and the sum is 0.
Example 3:

Input: nums = [1,2,3,4,5]
Output: 15
Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100


```

Basic Idea:

解法 1：Python built-in library 解法

```Python

class Solution:
    def sumOfUnique(self, nums: List[int]) -> int:
        return sum(val for val,cnt in Counter(nums).most_common() if cnt==1)

```

解法 2：就用一个哈希 map，但只处理第一次遇到和第二次遇到的情况，其他情况就一直 count++ 并忽略

```Python

class Solution:
    def sumOfUnique(self, nums: List[int]) -> int:
        counter = {}
        res = 0
        for val in nums:
            counter[val] = counter.get(val,0) + 1
            if counter[val]==1:
                res += val
            elif counter[val]==2:
                res -= val
        
        return res

```