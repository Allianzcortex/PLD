
This is Java solution

```Java

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] res = new int[26];
        for(int i=0;i<s.length();i++) {
            res[s.charAt(i)-'a']+=1;
            res[t.charAt(i)-'a']-=1;
        }
        
        // This is compare method 1
        // for(int i=0;i<26;i++)
        //     if(res[i]!=0)
        //         return false;
        // return true;
        
        // This is compare method 2
        Arrays.sort(res);
        return res[25]==0;
    }
}

```

---

Python Solution

```Python

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s)!=len(t)):
            return False
        res = [0]*26
        for i in range(len(s)):
            res[ord(s[i])-ord('a')] += 1
            res[ord(t[i])-ord('a')] -= 1
        
        return all(x==0 for x in res)
        

```