
Problem description:

```

Given an integer array nums and an integer k, modify the array in the following way:

choose an index i and replace nums[i] with -nums[i].
You should apply this process exactly k times. You may choose the same index i multiple times.

Return the largest possible sum of the array after modifying it in this way.

 

Example 1:

Input: nums = [4,2,3], k = 1
Output: 5
Explanation: Choose index 1 and nums becomes [4,-2,3].
Example 2:

Input: nums = [3,-1,0,2], k = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
Example 3:

Input: nums = [2,-3,-1,5,-4], k = 2
Output: 13
Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
 

Constraints:

1 <= nums.length <= 104
-100 <= nums[i] <= 100
1 <= k <= 104

```

Basic idea:

这道题思路不难，首先是要尽量把负数变正数。然后对剩余的 K,如果 k 是偶数，
那么什么都不用做；如果 k 是奇数，则选择一个最小的数让它变负。

一开始的两轮 sort 解法如下：

```Python

class Solution:
    def largestSumAfterKNegations(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        neg_cnt = sum([1 for num in nums if num<0])
        
        for i in range(min(neg_cnt,k)):
            nums[i]*= -1
            k -= 1
        
        nums.sort()
        if k>0 and k%2!=0:
            nums[0]*=-1
        
        return sum(nums)

```

但是既然要 2 轮 sort，那么显然用 minheap 来处理就是更好的数据结构，这里
用 heapreplace 来取代 `heappop & heappush`，前者时间复杂度 O(logN)，后者则为
两次 O(longN)(O(logN+logN))

解法如下：

总的时间复杂度为 `O(N+klogN)`
空间复杂度为 `O(1)`

```Python

from heapq import heappush,heapreplace

class Solution:
    def largestSumAfterKNegations(self, nums: List[int], k: int) -> int:
        
        heapify(nums)
        
        while k>0 and nums[0]<0:
            heapreplace(nums,-1*nums[0])
            k-=1
        
        if k%2==1:
            heapreplace(nums,-1*nums[0])
        
        return sum(nums)

```