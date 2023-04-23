
Problem description:

```

Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.
Example 2:

Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".
Example 3:

Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.
 

Constraints:

1 <= s.length <= 300
s contains only lowercase English letters.

```

Basic Idea:

这道题思路很清晰，就是用一个 map 来存储一个 character 最早出现的 index，之后依次遍历
并更新最大间距

Python 解法如下：

```Python

class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        match = {}
        res = -1
        for i,val in enumerate(s):
            # if it's alredy in, then we calcualte the dictance
            if val in match:
                res = max(res, i-match[val]-1)
            else:
            # let's keep the min index(ie the first places it appear)
                match[val]=i
        
        return res

```

TODO: Add Golang Solution