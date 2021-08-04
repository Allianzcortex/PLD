
Problem description :

```
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

```

Idea :

这道题相比于 349 关键是把重复的元素也都当作独立的个体来对待：

两种思路：

1. 使用和 349 一样的思路，先排序再比较

解法如下：

```Python

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        nums1.sort()
        nums2.sort()
        
        res = []
        
        i,j = 0,0
        
        while i<len(nums1) and j<len(nums2):
            
            if nums1[i]<nums2[j]:
                i += 1
            elif nums1[i]>nums2[j]:
                j += 1
            else:   
                # what if two are equal
                res.append(nums1[i])
                i += 1
                j += 1
        
        return res

```

2. 使用 counter 来计量每个元素出现的次数:

```Python

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        counter = {}
        res = []
        
        for num in nums1:
            if num not in counter:
                counter[num] = 0
            counter[num] += 1
            
        for num in nums2:
            if counter.get(num,0)!=0:
                res.append(num)
                counter[num] -= 1
        
        return res

```