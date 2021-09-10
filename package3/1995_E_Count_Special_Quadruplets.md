
Problem description:

```

Given a 0-indexed integer array nums, return the number of distinct quadruplets (a, b, c, d) such that:

nums[a] + nums[b] + nums[c] == nums[d], and
a < b < c < d
 

Example 1:

Input: nums = [1,2,3,6]
Output: 1
Explanation: The only quadruplet that satisfies the requirement is (0, 1, 2, 3) because 1 + 2 + 3 == 6.
Example 2:

Input: nums = [3,3,6,4,5]
Output: 0
Explanation: There are no such quadruplets in [3,3,6,4,5].
Example 3:

Input: nums = [1,1,1,3,5]
Output: 4
Explanation: The 4 quadruplets that satisfy the requirement are:
- (0, 1, 2, 3): 1 + 1 + 1 == 3
- (0, 1, 3, 4): 1 + 1 + 3 == 5
- (0, 2, 3, 4): 1 + 1 + 3 == 5
- (1, 2, 3, 4): 1 + 1 + 3 == 5

```

Basic idea:

自己一开始用的是暴力遍历，然后 AC :

```Python

class Solution:
    def countQuadruplets(self, nums: List[int]) -> int:
        """
        Input: nums = [1,2,3,6]
        Output: 1
        
        """
        
        if not nums or len(nums)==0:
            return 0
        
        n = len(nums)
        res = 0
        
        for i in range(n):
            for j in range(i+1,n):
                for k in range(j+1,n):
                    for l in range(k+1,n):
                        if nums[i]+nums[j]+nums[k]==nums[l]:
                            res += 1
        
        return res
```

---

另外一种思路是根据 `nums[a]+nums[b]+nums[c]=nums[d]`, 推导出公式：
`nums[a]+nums[b]=nums[d]-nums[c]`

之后就可以只遍历两次得出结果