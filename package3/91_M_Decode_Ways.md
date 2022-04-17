
Problem description :

```
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with 0.
The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
Hence, there are no valid ways to decode this since all digits need to be mapped.
Example 4:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

```

Below is my Python solution,
workds although a little rustic :

```Python

class Solution:
    def numDecodings(self, s: str) -> int:
        
        if not s:
            return 0
        
        dp = [1]+[0]*len(s)
        if s[0]!='0':
            dp[1] = 1
        
        for i in range(1,len(s)):
            if 1<=int(s[i])<=9:
                dp[i+1]+=(dp[i])
            
            if 10<=int(s[i-1:i+1])<=26:
                dp[i+1]+=dp[i-1]

        return dp[-1]

```

---


Next will be a more elegant Python solution :

```Python

class Solution:

    def numDecodings(self, s):
        #dp[i] = dp[i-1] if s[i] != "0"
        #       +dp[i-2] if "09" < s[i-1:i+1] < "27"
        if s == "": return 0
        dp = [0 for x_in range(len(s)+1)]
        dp[0] = 1
        for i in range(1, len(s)+1):
            if s[i-1] != "0":
                dp[i] += dp[i-1]
            if i != 1 and s[i-2:i] < "27" and s[i-2:i] > "09":  #"01"ways = 0
                dp[i] += dp[i-2]
        return dp[len(s)]

```

Below is Golang solution :

```Go

import "strconv"

func numDecodings(s string) int {
    
    dp:=make([]int,len(s)+1)
    dp[0] = 1
    
    for i:=0;i<len(s);i++ {
        if (s[i]!='0') {
            dp[i+1] += dp[i]
        }
        
        if (i>=1) {
            twoDigits,_:=strconv.Atoi(s[i-1:i+1])
            if (twoDigits>=1 && twoDigits<=26 && s[i-1]!='0') {
                dp[i+1]+=dp[i-1]
            }
       }
}
    
    return dp[len(s)]
}

```