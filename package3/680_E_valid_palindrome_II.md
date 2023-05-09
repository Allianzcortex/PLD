
Problem Description:

```

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.

```

Basic Idea:

可以去除最多一个字符，那么就是 (left+1,right) 和 (left,right-1) 两种操作，同时考虑到
最多可以这么做一次，就把 replace_count 写入函数参数中进行比较

这里首先上自己最早时候开始做的 Java 以及 Python 解法

```Java
class Solution {
      int delCount=0;
      public boolean validPalindrome(String s) {
          if(s==null || s.length()==0)
                return false;
           int i=0,j=s.length()-1;
           while(i<=j) {
               if(s.charAt(i)==s.charAt(j)){
                   i++;
                   j--;
               } else {
                   if(delCount==0){
                       delCount+=1;
                    return validPalindrome(s.substring(i,j)) || validPalindrome(s.substring(i+1,j+1));
                   }
                   return false;
               }
           }

           return true;
      }
}

```Python

class Solution:
    def validPalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] != s[right]:
                one, two = s[left:right], s[left + 1:right + 1]
                return one == one[::-1] or two == two[::-1]
            left, right = left + 1, right - 1
        return True

```

这两种解法都是为了 AC 而 AC，真是不行...里面用了大量的字符串截取操作，耗费时间空间，并且很多之前已经比较过的
字符会再次重复比较

这道题是 two pointers 题目，用两个指针来作比较是正解，Python 解法如下：

```Python

class Solution:
    def validPalindrome(self, s: str) -> bool:
        
        left,right = 0,len(s)-1
        return self._validate_with_counter(s,left,right,1)

    
    def _validate_with_counter(self,s,left,right,replace_cnt):

        while left<right:
            if s[left]==s[right]:
                left,right = left+1,right-1
            else:
                if replace_cnt==1:
                    # we can remove one character
                    case1 = self._validate_with_counter(s,left+1,right,0)
                    case2 = self._validate_with_counter(s,left,right-1,0)
                    return case1 or case2
                else:
                    return False
        
        return True

```