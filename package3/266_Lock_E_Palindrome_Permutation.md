
Problem Description:

```
Problem:
Given a string, determine if a permutation of the string could form a palindrome.

For example, "code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice? Count the frequency of each character. If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?

```

---

Java Solution :

```Java

class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        
        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                set.remove(ch);
            }else {
                set.add(ch);
            }
        }
        
        return set.size() <= 1;
    }
}


```

---

```Python

class Solution:
    def canPermutePalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        left = set()
        for c in s:
            if c in left:
                left.remove(c)
            else:
                left.add(c)
        return len(left) < 2
        
```