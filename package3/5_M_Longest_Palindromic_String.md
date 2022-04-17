
Problem description:

```

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"

```

Idea:

这道题有很多解法，自己记住用 DP 的这种，时间复杂度是 O(N^2)

有两种办法来构造 DP:

- i 从左往右，j 从 i 向 0 递减

- i 从右往左，j 从 i 向 len(s)-1 递增

Python 解法如下：

```Python

class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        dp = [[False]*len(s) for _ in s]
        
        length = len(s)
        maxRes ,left = 0,0
        
        for i in range(length-1,-1,-1):
            for j in range(i,length):
                if s[i]==s[j] and (j-i<=1):
                    dp[i][j] = True
                else:
                    dp[i][j] = dp[i+1][j-1] and s[i]==s[j]
                
                if dp[i][j] and (j-i+1)>maxRes:

                    left = i
                    maxRes = j-i+1
        
        return s[left:left+maxRes]

```

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