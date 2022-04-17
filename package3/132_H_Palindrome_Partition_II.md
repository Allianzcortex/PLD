
Problem description:

```
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1

```

Idea :

这道题和 Palindrome 以及 Palindrome Partition I 很像。

自己一开始的想法是求出 DP array 后再用 DFS 做，这种想法虽然可行但效率不高，TLE `25 / 33 test cases passed.`，实现如下：

```Python

class Solution:
    
    minCutCount = float('inf')
    
    def minCut(self, s: str) -> List[List[str]]:
        
        """
        dp[i][j] means : whether s[i..j] is palindrome
        
        """
        
        length = len(s)
        
        dp = [[False]*length for _ in range(length)]
        
        for i in range(length-1,-1,-1):
            for j in range(i,length):
                if s[i]==s[j]:
                    if (j-i<=1):
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i+1][j-1]

        self.dfs(s,0,-1,dp)
        
        return max(self.minCutCount,0)
    
    
    def dfs(self,s,index,cutCount,dp):
        
        """
        """
        # print(index)
        # print(cutCount>self.minCutCount)
        
        if cutCount>self.minCutCount:
            return
        
        if index==len(s):
            if cutCount<self.minCutCount:
                self.minCutCount = cutCount
                return
        
        for i in range(index,len(s)):
            if dp[index][i]:
                path.append(s[index:i+1])
                self.dfs(s,i+1,cutCount+1,dp)
                path.pop()

```

换种思路，从前往后遍历，如果 s[i..j] 为 palindrome 的话，那么对 minCut[j]，一定存在

`minCut[j] = 0 if i==0 else min(minCut[j],minCut[i-1]+1)` 的公式

且对 `minCut` 数组，存在 `minCut[j] = j` 的初始化方式：

所以关键就是用两个数组来实现 DP :

Python 解法如下：

```Python

class Solution:
    
    minCutCount = float('inf')
    
    def minCut(self, s: str) -> List[List[str]]:
        
        """
        dp[i][j] means : whether s[i..j] is palindrome
        
        """
        
        length = len(s)
        
        dp = [[False]*length for _ in range(length)]
        minCut = [float('inf')]*length
        
        for j in range(0,length):
            minCut[j] = j
            for i in range(0,j+1):
                if s[i]==s[j]:
                    if (j-i<=1):
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i+1][j-1]
                
                if dp[i][j]:
                    minCut[j] = 0 if i==0 else min(minCut[j],minCut[i-1]+1)
        
        return minCut[-1]

```

