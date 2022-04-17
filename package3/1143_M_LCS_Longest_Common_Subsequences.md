
Java Solution DP

```Java

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1==null || text2==null)
            return 0;
        int l1=text1.length(),l2=text2.length();
        int[][] dp = new int[l1+1][l2+1];
        
        for(int i=1;i<=l1;i++) {
            for(int j=1;j<=l2;j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] +1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }    
        }
        
        return dp[l1][l2];
    }
}
```

---

Python Solution : 

```Python

class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        # This way will generate duplicated array
        # dp = [[0]*(len(text2)+1)]*(len(text1)+1)
        dp = [[0]*(len(text2)+1) for _ in range(len(text1)+1)]
        for i in range(1,len(text1)+1):
            for j in range(1,len(text2)+1):
                if(text1[i-1]==text2[j-1]):
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        return dp[-1][-1]

```