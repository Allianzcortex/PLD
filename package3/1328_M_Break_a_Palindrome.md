
Problem description:

```

Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.

Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.

A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.

 

Example 1:

Input: palindrome = "abccba"
Output: "aaccba"
Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
Of all the ways, "aaccba" is the lexicographically smallest.
Example 2:

Input: palindrome = "a"
Output: ""
Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty string.
Example 3:

Input: palindrome = "aa"
Output: "ab"
Example 4:

Input: palindrome = "aba"
Output: "abb"

```

Basic idea :

这道题...自己一开始还是把它想复杂了，但还好，没有遗漏掉诸如：
- 中间元素无论如何都不能改
- 最后一个元素是 'a' 应该怎么办

这是自己一开始的解法，也 AC 了：

```Python

class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        """
        aacaa
        """
        if len(palindrome)<2:
            return ""
        
        array = list(palindrome)
        left,right = 0,len(array)-1
        
        # aba
        while left<=right:
            # 1 handle edge case
            if left==right and array[left]=='a':
                array[left]='b'
                break
            
            # 2 if it's in the middle or already the smallest,don't change
            if array[left]=='a' or (len(array)%2==1 and left==len(array)//2):
                left += 1
                continue
            else:
                array[left]='a'
                break
        
        return ''.join(array)

```

但其实可以简化很多，基本思路如下：

1. 因为是 Palindrome，所以只用考虑前半部分
2. 如果前半部分可以遇到一个不是 'a' 的，那么转为 'a' 就可以得到序列最小结果
3. 如果前半部分没有遇到，那就说明：
a) 对奇数数列，中间的元素无论换哪一个都还是 palindrome
b) 对奇偶数列，后面的元素也全是 'a'
4. 则这个时候只需要把最后一个元素换成 'b' 即可

现在来看确实很容易，但面试时候不知道自己是否能在有限时间内做出来

Python 解法如下：

```Python

class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        if len(palindrome)<2:
            return ""
        
        arr = list(palindrome)
        
        for i in range(len(arr)//2):
            if arr[i]!='a':
                arr[i]='a'
                return ''.join(arr)
        
        arr[-1] = 'b'
        
        return ''.join(arr)
```

---

Golang 解法如下：

```Golang

func breakPalindrome(palindrome string) string {
    
    arr:=[]rune(palindrome)
    length:=len(arr)
    
    if length<=1 {
        return ""
    }
    
    for left:=0;left<length/2;left++ {
        if arr[left]!='a' {
            arr[left]='a'
            return string(arr)
        }
    }
    
    arr[length-1] = 'b'
    return string(arr)
    
}

```