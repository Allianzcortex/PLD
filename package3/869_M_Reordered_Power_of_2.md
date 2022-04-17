Problem Description:

```
Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.

 

Example 1:

Input: 1
Output: true
Example 2:

Input: 10
Output: false
Example 3:

Input: 16
Output: true
Example 4:

Input: 24
Output: false
Example 5:

Input: 46
Output: true
 

Note:

1 <= N <= 10^9


```

---

Initially my idea is to generate all combinations and check whether each one is power of 2, actually
this is not an effective solution :

We can generate all possible power of 2 results, and check whether string is one of them(using sorted or counter)

Python Solution 1:

```Python
class Solution:
    def reorderedPowerOf2(self, N: int) -> bool:
        
        return sorted(str(N)) in [sorted(str(1<<i)) for i in range(33)]
```

---

Python Solution 2:

```Python

class Solution:
    def reorderedPowerOf2(self, N: int) -> bool:
        
        c1 = Counter(str(N))
        for i in range(30):
            n = int(math.pow(2, i))
            if Counter(str(n)) == c1: return True
        return False

```