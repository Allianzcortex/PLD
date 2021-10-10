
Problem description:

```
You are given a string s, return the number of segments in the string. 

A segment is defined to be a contiguous sequence of non-space characters.

 

Example 1:

Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
Example 2:

Input: s = "Hello"
Output: 1
Example 3:

Input: s = "love live! mu'sic forever"
Output: 4
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 300
s consists of lower-case and upper-case English letters, digits or one of the following characters "!@#$%^&*()_+-=',.:".
The only space character in s is ' '.

```

Basic idea:

自己一开始的思路是用 Binary Search，也 AC 了：
只要发现左边的一块，不管右边是 end of segment 还是 end of string
都算 +1

```Python

class Solution:
    def countSegments(self, s: str) -> int:
        count = 0
        
        left,right = 0,len(s)-1
        
        while left<=right:
            while left<=right and s[left]==" ":
                left += 1
            
            if left<=right:
                count += 1
            index = left+1
            
            while index<=right and s[index]!=" ":
                index += 1
            
            left = index
        
        return count

```

不过在看解析的时候发现了一个更棒的思路，如下：
一个 segment 成立的前提是：

a. 一个不为空的 character 是 string 的一开始部分
b. 一个不为空的 character 左边部分是一个为空的 character

只要满足 `a||b` 我们就将结果 + 1

```Java

public int countSegments(String s) {
    int res=0;
    for(int i=0; i<s.length(); i++)
        if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
            res++;        
    return res;
}

```