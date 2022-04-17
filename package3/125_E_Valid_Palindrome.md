
Problem description:

```
Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

```

Below is Java Solution :

```Java
class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0)
            return true;
        
        int left=0,right = s.length()-1;
        char[] arr = s.toCharArray();
        // why donot use left<=right ? to handle the case like "  "
        // Need to think about it more carefully
        while(left<right) {
            while(left<right && !Character.isLetterOrDigit(arr[left]))
                left ++;
            while(left<right && !Character.isLetterOrDigit(arr[right]))
                right --;
//             Returns:
// the lowercase equivalent of the character, if any; otherwise, the character itself.
            if(Character.toUpperCase(arr[left++])!=Character.toUpperCase(arr[right--]))
                return false;
        }
        
        return true;
    }
}

```

---

A tricky one though : 

```Java

class Solution {
    public boolean isPalindrome(String s) {
        String temp = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        return temp.equals(new StringBuilder(temp).reverse().toString());
    }
}


```

---

Python Solution :

two-lines solution

```Python

class Solution:
    def isPalindrome(self, s: str) -> bool:
        s=[x.lower() for x in s if x.isalnum()]
        return s==s[::-1]
        
```

And using 2 indexes to sovle it :

```Python

class Solution:
    def isPalindrome(self, s: str) -> bool:
        left,right = 0,len(s)-1
        
        while left<=right:
            while left<right and not s[left].isalpha():
                left += 1
            
            while left<right and not s[right].isalpha():
                right -= 1
            
            if left<=right and s[left].lower()!=s[right].lower():
                return False

            left += 1
            right -= 1
        
        return True

```