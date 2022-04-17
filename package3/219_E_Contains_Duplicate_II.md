
Problem description:

```
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105

```

Basic idea:

记录所有出现的 index 并进行比较

Python 解法如下：

```Python

class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        
        s = defaultdict(list)
        
        for index,val in enumerate(nums):
            s[val].append(index)
            values = s[val]

            if len(values)>1 and values[-1]-values[-2]<=k:
                return True
        
        return False

```

TODO : add Golang solution