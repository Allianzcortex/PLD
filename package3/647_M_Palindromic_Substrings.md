
Problem description:

```

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

```

Basic idea:

If a string is palindromic,then there are 2 cases for its length :

1. its odd
2. its even

---

Python 解法如下：

```Python

Python Solution

```Python

class Solution:
    def countSubstrings(self, s: str) -> int:
        count = 0
        for index in range(len(s)):
            count += self.extendPalindrome(s,index,index)
            count += self.extendPalindrome(s,index,index+1)
        return count
    
    def extendPalindrome(self,s: str,i:int,j:int)->int :
        count = 0
        while(i>=0 and j<len(s) and s[i]==s[j]):
            count += 1
            i -= 1
            j += 1
        return count

```

```

Java Solution :

```Java

class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++) {
            count+=extendPalindrome(s,i,i);
            count+=extendPalindrome(s,i,i+1);
        }

        return count;
    }

    public int extendPalindrome(String s,int i,int j) {
        int count = 0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
            count += 1;
            i--;
            j++;
        }

        return count;
    }
}

```

---

