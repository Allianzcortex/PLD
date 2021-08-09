
Problem description:

```

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.

```

Idea : 这道题有一种解法是暴力 DFS 依次探索，我们可以用一种优化的方式
就是提前计算好用 dp[i..j] 来表示 s[i..j] 是否为 palindrome，然后再用 dfs 来求解：

Python 解法如下

```Python

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        
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
        
        res = []
        self.dfs(s,0,[],res,dp)
        
        return res
    
    
    def dfs(self,s,index,path,res,dp):
        
        """
        """
        
        if index==len(s):
            res.append(path[:])
            return
        
        for i in range(index,len(s)):
            if dp[index][i]:
                path.append(s[index:i+1])
                self.dfs(s,i+1,path,res,dp)
                path.pop()

```