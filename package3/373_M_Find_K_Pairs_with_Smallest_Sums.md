
Problem description:

```
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

 

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 

Constraints:

1 <= nums1.length, nums2.length <= 105
-109 <= nums1[i], nums2[i] <= 109
nums1 and nums2 both are sorted in ascending order.
1 <= k <= 1000

```

这道题其实和 ugly number 有点像，都是关于最小 index 的生成

用 heap 来存储之前最小的 (sum,x,y) 之后再对 x,y 选择是否 + 1

对应 Python 代码如下：

```Python


from heapq import heappush,heappop

class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        queue = []
        
        len1,len2 = len(nums1),len(nums2)
        visited = set()
        res = []
        heappush(queue,(nums1[0]+nums2[0],0,0))
        visited.add((0,0))
        
        while len(res)<k and queue:
            
            _,x,y = heappop(queue)
            res.append([nums1[x],nums2[y]])
            
            if x<len1-1 and (x+1,y) not in visited:
                visited.add((x+1,y))
                heappush(queue,(nums1[x+1]+nums2[y],x+1,y))
            
            if y<len2-1 and (x,y+1) not in visited:
                visited.add((x,y+1))
                heappush(queue,(nums1[x]+nums2[y+1],x,y+1))
        
        
        return res

```