
Firstly we build a DP boolean array.

```Java
class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start=0,maxLength=1;
        // This is the 1st way to build the DP matrix
        // for(int i=0;i<len;i++) {
        //        for(int j=i;j>=0;j--) {
        //         dp[j][i] = s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1]);
        //         if(dp[j][i] && i-j+1>maxLength) {
        //             start = j;
        //             maxLength = i-j+1;
        //         }
        //     }
        // }
        
        // This is the 2nd way
        for(int i=len-1;i>=0;i--) {
            for(int j=i;j<len;j++) {
                dp[i][j] = s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]);
                if(dp[i][j] && j-i+1>maxLength) {
                    start = i;
                    maxLength = j-i+1;
                }
            }
        }
        
        return s.substring(start,start+maxLength);
    }
}

```

---

Or we can use the problem 647 as the reference:

```Java

class Solution {
    private int maxLength = 1;
    private int start = 0;
    
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return "";
        
        for(int i=0;i<s.length();i++) {
            validatePalindrome(s,i,i);
            validatePalindrome(s,i,i+1);
        }
        
        return s.substring(start,start+maxLength);
    }
    
    public void validatePalindrome(String s,int left,int right) {
        
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        
        if(right-left-1>maxLength) {
            start = left+1;
            maxLength = right - left -1;
        }
    }
}

```