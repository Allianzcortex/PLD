
Problem Description :

```
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.

```

Basic idea is here :

every time , starting from left, remvoe the peak element(peak element
is the first element that no smaller than right one).

So code is :

```Python

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        res = ""
        
        while k>0:
            index = 0
            while index<len(num)-1 and num[index]<=num[index+1]:
                index += 1
            
            num = num[:index] + num[index+1:]
            k -= 1
        
        if(num==""):
            return "0"
        
        left = 0
        while left<len(num) and num[left] == '0':
            left += 1
        
        return num[left:] if left<=len(num)-1 else "0"
```

But this is not so efficient. Actually we can use stakc to mock the 
behaviour. We push element into stack every time, and if we find the 
top of stack is bigger than current one, we know that the top of stack
should be poped.

Finally we also need to handle leading zero :

The solution is like :

```Python

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        
        for ch in num:
            
            while (len(stack)>0 and k>0 and stack[-1]>ch):
                stack.pop()
                k -= 1
            
            stack.append(ch)
            
        while k>0:
            stack.pop()
            k -= 1
            
        res = "".join(stack).lstrip("0")
            
        # left = 0
        # while left<len(res) and res[left]=='0':
        #     left += 1
            
        return res or "0"

```