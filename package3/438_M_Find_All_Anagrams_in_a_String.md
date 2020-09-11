
This is the intuitive solution,but not effective apprently.

# we should use two sliding window to solve this problem

```Java

class Solution {
    /**
     a b c
     a b
    **/
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int lenS=s.length(),lenP=p.length();
        for(int i=0;i<=lenS-lenP;i++) {
            if(isSubstring(s.substring(i,i+lenP),p))
                res.add(i);
        }
        
        return res;
    }
    
    public boolean isSubstring(String s1,String s2) {
        int[] res = new int[26];
        for(int i=0;i<s1.length();i++) {
            res[s1.charAt(i)-'a']++;
            res[s2.charAt(i)-'a']--;
        }
        
        return Arrays.stream(res).allMatch(x->x==0);
    }
}

```

---

Sliding Window Solution

```Java


```

"""
cbaebabacd
abc
"""

abc 3