
Problem description:

```
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

```

Basic idea:

滑动窗口题目。下面是 Python 的实现：

第一种实现，用一个 `map` 来纪录上一个 `ch` 出现的 index，如果上一次
出现的在 `start` 的右边，那么就意味着需要重新计算 `start`，否则的话
就每次更新 `maxLength`。

```Python

class Solution:

    def lengthOfLongestSubstring(self, s: str) -> int:
        counter = {}
        start = maxLength = 0
        
        for index, ch in enumerate(s):
            if ch in counter and counter[ch]>=start:
                start = counter[ch]+1
            else:
                maxLength = max(maxLength,index-start+1)
            
            counter[ch] = index
            
        return maxLength

```

下面是 sliding window 的第二种实现，用一个 map 来存储

```Python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        res = 0
        counter = defaultdict(lambda:0)
        
        for right in range(len(s)):
            right_ch = s[right]
            while counter[right_ch] != 0:
                counter[s[left]]-= 1
                left += 1
            
            counter[right_ch]+=1
            res = max(res,right-left+1)
        
        return res
```

```

The key is to consider this line : 

` j = Math.max(j,map.get(ch)+1);` 

an example case is : `abbac`. 
if we use `j=map.get(ch)+1` : 
we iterate over the string:
a -> j=0
b -> j=0
b -> j=2
a -> j=1 -> This is not what we want. We want it to be 3.

It means if we want to skip the middle duplicated items, then we 
need to use `j = Math.max(j,map.get(ch)+1)`

```Java

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int j = 0,maxLength=0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                j = Math.max(j,map.get(ch)+1);
            }
            
            map.put(ch,i);
            maxLength = Math.max(maxLength,i-j+1);
        }
        
        return maxLength;
    }
}

```

