
Problem description:

```

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109

```

Basic idea:

这道题一看起来确实不像是可以直接用 Bianry Search 的题目，但仔细分析就会发现：

每一次 Koko 能吃的 Bananas，最小是 1，最多是 max(piles)

如果 middle 时候可以吃完，那么就保存 middle 值并尝试减少
如果 middle 时候不可以吃完那么就肯定要增多

Python 解法如下：

```Python

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        
        left,right = 1,max(piles)
        res = -1
        
        while left<=right:
            middle = left+(right-left)//2
            if self._can_eat_all(piles,middle,h):
                res = middle
                right = middle-1
            else:
                left = middle+1
        
        return res
    
    
    def _can_eat_all(self,piles,k,h):
        
        hour = 0
        
        for p in piles:
            if p%k==0:
                hour += p//k
            else:
                hour += (p//k + 1)
        
        return hour<=h

```