
Problem description:

```
Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

 

Example 1:

Input: n = 5
Output: true
Explanation: The binary representation of 5 is: 101
Example 2:

Input: n = 7
Output: false
Explanation: The binary representation of 7 is: 111.
Example 3:

Input: n = 11
Output: false
Explanation: The binary representation of 11 is: 1011.
Example 4:

Input: n = 10
Output: true
Explanation: The binary representation of 10 is: 1010.
Example 5:

Input: n = 3
Output: false
 

Constraints:

1 <= n <= 231 - 1
```

---

Basic idea:

这道题是关于位操作的题目，就用一种直接的方法来做吧，通过 `bin()`
函数得到二进制表示再进行字符串操作

```Python
class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        res = bin(n)[2:]
        
        for i in range(1,len(res)):
            if res[i]==res[i-1]:
                return False
        
        return True

```