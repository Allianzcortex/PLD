
Problem Description :

```

Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.

Given two positive integers left and right represented as strings, return the number of super-palindromes integers in the inclusive range [left, right].

 

Example 1:

Input: left = "4", right = "1000"
Output: 4
Explanation: 4, 9, 121, and 484 are superpalindromes.
Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
Example 2:

Input: left = "1", right = "2"
Output: 1
 

Constraints:

1 <= left.length, right.length <= 18
left and right consist of only digits.
left and right cannot have leading zeros.
left and right represent integers in the range [1, 1018].
left is less than or equal to right.

```

---

Solution :

The key is to find the boundary

```Python

class Solution:
    def superpalindromesInRange(self, left: str, right: str) -> int:
        res = 0
        left,right = int(left),int(right)
        l,r = len(str(int(sqrt(left))))-1, len(str(int(sqrt(right))))+1
        n1 = (l)//2-1
        n2 = (r)//2
        
        low,high=int(10**n1),int(10**n2)
        for i in range(low,high):
            x = str(i)
            even = int(x+x[::-1])
            odd = int(x+x[:-1][::-1])
            for num in [even,odd]:
                sum = num*num
                if str(sum)==str(sum)[::-1] and left<=sum<=right:
                    res += 1
        
        return res

```