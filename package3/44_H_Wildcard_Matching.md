The most important is to get all the logic right.

Problem Description:

```
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input: s = "adceb", p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input: s = "acdcb", p = "a*c?b"
Output: false

```


TLE Version :
```Java
class Solution {
    public boolean isMatch(String s, String p) {
        return compare(s,p,0,0,s.length(),p.length());
    }
    
    public boolean compare(String s,String p,int i,int j,int lenS,int lenP) {
        // case 1 can match
        if(i==lenS && j==lenP)
            return true;
        
        // case 2 if j has reached the end and i is not,then it will never match,return false instead
        if(j==lenP)
            return false;

        // case 3 
        if(i==lenS) 
            return p.charAt(j)=='*' && compare(s,p,i,j+1,lenS,lenP);
        
        if(p.charAt(j)=='*') {
            return compare(s,p,i+1,j,lenS,lenP) || compare(s,p,i,j+1,lenS,lenP);
        } else if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
            return compare(s,p,i+1,j+1,lenS,lenP);
        } else
            return false;
    }
}
```

Use Memo from Top to botton version :

```Java
class Solution {
    public boolean isMatch(String s, String p) {
        Map<List<Integer>,Boolean> map = new HashMap<>();
        return compare(s,p,0,0,s.length(),p.length(),map);
    }
    
    public boolean compare(String s,String p,int i,int j,int lenS,int lenP,Map<List<Integer>,Boolean> map) {
        List<Integer> key = Arrays.asList(i,j);
        if(map.containsKey(key))
            return map.get(key);
        boolean res = false;
        if(i==lenS && j==lenP)
            res = true;
        else if(j==lenP)
            res = false;
        else if(i==lenS) 
            res = p.charAt(j)=='*' && compare(s,p,i,j+1,lenS,lenP,map);
        else if(p.charAt(j)=='*') {
            res = compare(s,p,i+1,j,lenS,lenP,map) || compare(s,p,i,j+1,lenS,lenP,map);
        } else if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
            res = compare(s,p,i+1,j+1,lenS,lenP,map);
        } else {
            res = false;
        }
        
        map.put(key,res);
        return res;
    }
}

```

Then this will be the AC Solution :

```Java

class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        // (i,j) means (i-1)..(j-1)
        for(int i=0;i<m+1;i++) {
            for(int j=0;j<n+1;j++) {
                if(i==0 && j==0)
                    dp[i][j] = true;
                else if(j==0)
                    dp[i][0] = false;
                else if(i==0)
                    dp[i][j]=p.charAt(j-1)=='*' && dp[i][j-1];
                else if(p.charAt(j-1)=='*')
                    dp[i][j]=dp[i][j-1] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j-1] && (p.charAt(j-1)=='?' || s.charAt(i-1)==p.charAt(j-1));
            }
        }
        
        return dp[m][n];
    }
}

```

Below is Python Solution:

这道题是很典型的 DP 题，关键是要推断出规律。

普遍规律是：

`dp[i][j]` 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配，所以：

1. 如果 `p[j]` 是小写字母，那么 dp[i][j] = dp[i-1][j-1] && s[j]==p[j]

2. 如果 `p[j]` 是 '?'，那么这个就不重要，dp[i][j] = dp[i-1][j-1]

3. 如果 `p[j]` 是 '*', 那么 dp[i][j] = dp[i][j-1] || dp[i-1][j]

同时为了方便起见，要考虑数据的初始化情况。

- dp[0][0] 为 True

- 对 dp[0][1..l2]，因为 s 不出一个字符，所以只有当 p 为 `*`/`**`/`***` 的时候才匹配

- 对 dp[1...l1][0]，因为 p 不出一个字符，所以不可能匹配，全为 False

代码如下：

```Python

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        l1,l2 = len(s),len(p)
        dp = [[False]*(l2+1) for _ in range(l1+1)]
        
        # dp[i][j] means the first i-1 character of s
        # whether matches the first j-1 character of p
        
        dp[0][0] = True
        
        for i in range(1,l1+1):
            dp[i][0] = False
        
        for i in range(1,l2+1):
            if p[i-1]=='*':
                dp[0][i] = True
            else:
                break
        
        for i in range(1,l1+1):
            for j in range(1,l2+1):
                if p[j-1]=='?':
                    dp[i][j] = dp[i-1][j-1]
                elif p[j-1]=='*':
                    dp[i][j] = dp[i-1][j] or dp[i][j-1]
                else:
                    dp[i][j] = dp[i-1][j-1] and s[i-1]==p[j-1]

        return dp[l1][l2]

```