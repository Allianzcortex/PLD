
Problem description:

```

A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:

s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1].
Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.

 

Example 1:

Input: s = "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: s = "III"
Output: [0,1,2,3]
Example 3:

Input: s = "DDI"
Output: [3,2,0,1]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'I' or 'D'.

```

Basic idea:

这道题还是很容易找出规律的。遇到 `D` 时把最大数加上，遇上 `I`时把最小数加上

AC 代码如下：

```Python

class Solution:
    def diStringMatch(self, s: str) -> List[int]:
        
        res = []
        nums = list(range(len(s)+1))
        
        left,right = 0,len(s)
        
        for ch in s:
            if ch=='D':
                res.append(nums[right])
                right-=1
            else:
                res.append(nums[left])
                left+=1

        # 这里看起来不用这么复杂，因为 `left` 和 `right` 会相遇
        res.append(nums[left] if nums[-1]==nums[right] else nums[right])
        return res

```