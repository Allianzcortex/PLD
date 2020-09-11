Basic idea :

This problem can be a little tricky


```Java

class Solution {
    public int longestStrChain(String[] words) {
        int len = words.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        Arrays.sort(words,(w1,w2)->(w1.length()-w2.length()));
        int res = 1;
        for(int i=1;i<words.length;i++) {
            for(int j=0;j<i;j++) {
                if(isSuper(words[j],words[i])) {
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            
            res = Math.max(res,dp[i]);
        }
        
        return res;
        
    }
    
    public boolean isSuper(String w1,String w2) {
        if(w1.length()+1!=w2.length())
            return false;
        int i=0,j=0,diff=0;
        while(i<w1.length() && j<w2.length()) {
            if(w1.charAt(i)==w2.charAt(j)) {
                i++;
                j++;
            } else {
                diff++;
                if(diff>1)
                    return false;
                j++;
            }
        }
        
        return true;
        
    }
}

```

While solution here is more clear : 

https://leetcode.com/problems/longest-string-chain/discuss/294890/C%2B%2BJavaPython-DP-Solution

May add it later with Python solutions