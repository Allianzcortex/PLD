
Java is decreasing
Python is increasing

Two interesting solutions


Java Solution

```Java

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        String minStr = strs[0];
        for(String str:strs) {
            while(str.indexOf(minStr)!=0)
                minStr = minStr.substring(0,minStr.length()-1);
        }
        
        return minStr;
    }
}

```

---

Python Solution :

```Python

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if(strs == []):
            return ""
        min_word = min(strs)
        for i,ch in enumerate(min_word):
            for others in strs:
                if(others[i]!=ch):
                    return min_word[:i]
        return min_word
```