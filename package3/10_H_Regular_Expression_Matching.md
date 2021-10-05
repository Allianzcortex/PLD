
Problem description:

```

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input: s = "aab", p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input: s = "mississippi", p = "mis*is*p*."
Output: false

```

Basic idea :

和 Edit Distance 一样，要注意的是推导方程的建立

在初始化数组时，如果 p[i]=='*' 并且 dp[i-1][0] 为 True
那么之后的 dp[i+1][0] 也为 True

---

Python 解法如下：

```Python

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        lenP,lenS = len(p),len(s)
        
        """
        wanna know whether p and s are matched
        
        dp[i][j] = [the first i character of p] is whether matched with 
                   [the first j character of s]
        
        """
        
        dp = [ [False]*(lenS+1) for _ in range(lenP+1)]
        dp[0][0] = True
        
        for i in range(lenP):
            if p[i]=='*' and dp[i-1][0]:
                dp[i+1][0] = True
                
        # print(dp)
        for i in range(lenP):
            for j in range(lenS):
                if p[i]==s[j] or p[i]=='.':
                    dp[i+1][j+1] = dp[i][j]
                
                if p[i]=='*':
                    if (p[i-1]!=s[j] and p[i-1]!='.'):
                        dp[i+1][j+1] = dp[i-1][j+1]
                    else:
                        dp[i+1][j+1] = dp[i][j+1] or dp[i+1][j] or dp[i-1][j+1]
        
        return dp[-1][-1]

```

Java 解法如下：

```Java

public class Solution {
    
public boolean isMatch(String s, String p) {

    if (s == null || p == null) {
        return false;
    }
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == '*' && dp[0][i-1]) {
            dp[0][i+1] = true;
        }
    }
    for (int i = 0 ; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '.') {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == s.charAt(i)) {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == '*') {
                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                    dp[i+1][j+1] = dp[i+1][j-1];
                } else {
                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
    }   
    return dp[s.length()][p.length()];
}
}

```