
Use DP Solution

```Java

class Solution {
    public int numOfSubarrays(int[] arr) {
        
        /**
        odd + odd = even
        odd + even = odd
        even + odd = odd
        even + even = even
        
        dp[x][0]: it ends with odd
        dp[x][1]: it ends with even
        **/
        
        if(arr==null || arr.length==0)
            return 0;
        
        int mod=1_000_000_007;
        
        int[][] dp = new int[arr.length][2];
        dp[0][0]=arr[0]%2;
        dp[0][1]=arr[0]%2==0?1:0;
        
        for(int i=1;i<arr.length;i++) {
            if(arr[i]%2==0) {
                // item i is even
                dp[i][0]=dp[i-1][0];
                dp[i][1]=(dp[i-1][1]+1)%mod;
            } else {
                // item i is odd
                dp[i][0]=(1+dp[i-1][1])%mod;
                dp[i][1]=dp[i-1][0];
            }
        }
        
        int res=0;
        for(int i=0;i<dp.length;i++)
            res=(res+dp[i][0])%mod;
        
        return res;
        
    }
}

```


And for reference , use Prefix sum, the idea is same and it 
optimizes space complexity

```Java

public int numOfSubarrays(int[] arr) {
        int odd = 0, even = 1, res = 0, sum = 0, mod = 1_000_000_007; // treat empty subarray as even
        for (int n : arr) {
            sum += n;
            if (sum % 2 == 0) {
                even++;
                res = (res + odd) % mod;
            } else {
                odd++;
                res = (res + even) % mod;
            }
        }
        return res;
    }

```