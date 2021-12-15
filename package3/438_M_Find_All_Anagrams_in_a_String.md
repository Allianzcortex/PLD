
Problem description:

```
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.

```

Basic idea: 

这道题一看就是 sliding window 的典型应用


Python 解法如下：

```


```

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
