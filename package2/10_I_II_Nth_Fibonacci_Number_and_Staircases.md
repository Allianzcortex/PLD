Question I:

```Java

class Solution {
    public int fib(int n) {
        int[] dp=new int[n<3?3:n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
            dp[i]=(dp[i-1]+dp[i-2])%(int)(1e9+7);
        return dp[n];
    }
}

```

Question II:

```Java

class Solution {
    public int numWays(int n) {
        if(n==0 || n==1)
            return 1;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++)
            dp[i]=dp[i-1]%1000000007+dp[i-2]%1000000007;
        return dp[n]%1000000007;
    }
}

```