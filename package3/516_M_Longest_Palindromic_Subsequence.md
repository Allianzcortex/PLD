
This will be the output for `bbbab` :

```
1 0 0 0 0 
2 1 0 0 0 
3 2 1 0 0 
3 2 1 1 0 
4 3 3 1 1 
```

Java Solution :

```Java

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp=new int[len][len];
        for(int i=0;i<len;i++) {
            dp[i][i] = 1;
            for(int j=i-1;j>=0;j--) {
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j] = dp[i-1][j+1]+2;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j+1]);
            }
        }
        }
        
        return dp[len-1][0];
    }
}

```

---

Python Solution : 

```Python
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        dp = [[0]*len(s) for _ in s]
        print(len(dp),len(dp[0]))
        for i in range(0,len(s)):
            dp[i][i] = 1
            for j in range(i-1,-1,-1):
                if s[i]==s[j]:
                    dp[i][j] = dp[i-1][j+1]+2
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i][j+1])
        
        return dp[-1][0]
        

```