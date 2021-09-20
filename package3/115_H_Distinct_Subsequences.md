
Problem description:

```

Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It is guaranteed the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
babgbag
babgbag
babgbag
babgbag
babgbag

```

Basic idea :

自己一开始看这道题的时候想法是用 DFS 遍历出可能的情况，并且自己的解法也确实是正确的，
但只能应对 50 个 testcase，再多的话就 TLE :

```Python

class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        if not s or not t or len(s)<len(t):
            return 0
        
        res = 0
        for i in range(0,len(s)-len(t)+1):
            res += self.dfs(i,s,s[i],t,0)
            
        return res
    
    
    def dfs(self,left,s,curr,t,index):
        if curr[-1]!=t[index]:
            return 0
        if len(curr)==len(t):
            return 1
        
        res = 0
        for i in range(left+1,len(s)):
            res += self.dfs(i,s,curr+s[i],t,index+1)
        return res

```

---


所以更好的解法还是用 DP 来做：

问题问的是 s 是否包含 t，所以定义数组：`dp[len(s)+1][len(t)+1]`
状态转换公式如下：

```
dp[i+1][j+1] 表示的是 s[0..i] 包含的 t[0..j] 的个数
最后我们需要的就是 dp[-1][-1]

接下来对数据进行初始化：当 `j==0` 时，意味着 t 数组为空字符串，而对 s 来说，
不管 s 是什么，都有一种办法来生成空字符串(就是所有元素都不取)，所以对所有的
i，dp[i][0] 都应该等于 1.

而当 `i==0` 时，意味着 s 数组为空字符串，也就是 s 数组没办法生成 t，所以仍然
为默认值，是 0.

接下来看状态转换公式：

dp[i+1][j+1] = dp[i][j+1] if s[i]!=t[j] 
如果 s[i] 和 t[j] 不相等的话那么就看 s[0..i-1] 包含了几个 t[j]

dp[i+1][j+1] = dp[i][j+1] + dp[i][j]
如果 s[i] 和 t[j] 相等的话，那么有两种选择：
a. 选择 t[j] 这个元素，dp[i+1][j+1] = dp[i][j]
b. 不选择 t[j] 这个元素，和上面的状态相同，dp[i+1][j+1] = dp[i+1][j]

可以用 `abb` 和 `ab` 

```

Python AC 代码如下：

```Python

class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        
        row,column = len(s),len(t)
        
        dp = [[0]*(column+1) for _ in range(row+1)]
        
        # firstly , initialize the first row to 1
        for i in range(row+1):
            dp[i][0] = 1
        
        for i in range(row):
            for j in range(column):
                if s[i]==t[j]:
                    dp[i+1][j+1] = dp[i][j+1] + dp[i][j]
                else:
                    dp[i+1][j+1] = dp[i][j+1]
        
        return dp[-1][-1]

```