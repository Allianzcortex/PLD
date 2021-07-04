
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

While using Python , this will be a classic sliding window problem:

Here is Python Solution:

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