
Problem description:

```

Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

 

Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true

```

---

Basic idea:

这道题的 DP 解法竟然和自己一开始想的是一样的...
dp[i][j] 表示 s1[0..i] 和 s2[0..j] 是否 match s[0..(i+j)]

对应状态方程是：dp[i][j] = dp[i][j] or (dp[i][j-1] and s2[j-1]==s3[i+j-1]) or 
                               dp[i-1][j] and s1[i-1]==s3[i+j-1])
三个中只要满足任何一个就都成立

要注意的是对 `dp[0][0] / dp[0][0..j] / dp[0..i][0]` 的处理

这道题还是需要再做一遍

Python 解法如下：

```Python

class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        
        len1,len2 = len(s1),len(s2)
        
        if len1+len2 != len(s3):
            return False
        
        dp = [[False]*(len2+1) for _ in range(len1+1)]
        
        for i in range(len1+1):
            for j in range(len2+1):
                
                if i==0 and j==0:
                    dp[i][j] = True
                
                elif i==0:
                    dp[i][j] = dp[i][j-1] and s2[j-1]==s3[j-1]
                
                elif j==0:
                    dp[i][j] = dp[i-1][j] and s1[i-1]==s3[i-1]
                
                else:
                    dp[i][j] = (dp[i][j] or (dp[i][j-1] and s2[j-1]==s3[i+j-1]) or 
                               dp[i-1][j] and s1[i-1]==s3[i+j-1])
        
        return dp[-1][-1]

```
