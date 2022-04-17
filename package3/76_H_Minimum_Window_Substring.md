Problem Description:

```
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?

```
Basic idea:

这是很经典的滑动窗口题目

#### a pretty clean link:
https://leetcode.com/problems/minimum-window-substring/discuss/226911/Python-two-pointer-sliding-window-with-explanation

```Python
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        """
        Obviously we can use sliding window(two pointers) to solve this porblem.
        """

        t_counter = Counter(t)
        
        left,total = 0,len(t)
        res = 0
        min_str = ""
        
        for right in range(len(s)):

            if t_counter[s[right]]>0:
                total -= 1            
            t_counter[s[right]]-=1
            
            while total==0:
                if min_str=="" or (right-left+1 < len(min_str)):
                    min_str = s[left:right+1]
                t_counter[s[left]] += 1
                
                if(t_counter[s[left]] > 0):
                    total += 1

                left += 1
        
        return min_str

```

I'm stuck at increase/decrease logic here:

But actually we just need to increase/decrease counter directly without considering `if` logic.