
Problem description:

```

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 
```

---

Idea :

1. 第一种解法就是用 Python 的 built-in set

```Python

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:

        return list(set(nums1).intersection(set(nums2)))
        # or we use
        return list(set(nums1) & set(nums2))

```

2. 第二种解法是对两个数组都排序，然后逐一比较：


```Python

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        nums1.sort()
        nums2.sort()
        
        i,j = 0,0
        res = []
        
        while i<len(nums1) and j<len(nums2):
            
            if nums1[i]<nums2[j]:
                i += 1
            elif nums1[i]>nums2[j]:
                j += 1
            else:
                if not (res and res[-1]==nums1[i]):
                    res.append(nums1[i])
                i += 1
                j += 1
        
        return res
```