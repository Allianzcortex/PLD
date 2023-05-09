
Problem description:

```

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.

```

Basic Idea:

确实是 easy 题...

Java 解法如下：

```Java
class Solution {
    public void reverseString(char[] s) {
        if(s==null || s.length==0)
            return;
        int left=0,right=s.length-1;
        while(left<=right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
    }
}
```

or If we want,we can change the following into :

```Java

char temp = s[left];
s[left++] = s[right];
s[right--] = temp;

```

Python 解法如下：

```Python

class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        if s is None or len(s)==0:
            return s
        
        left,right = 0,len(s)-1
        while left<right:
            s[left],s[right] = s[right],s[left]
            left += 1
            right -= 1

```

Golang 解法如下：

```Golang

func reverseString(s []byte)  {
    
    for left,right:=0,len(s)-1;left<right; {
        // swap characters
        temp:=s[left]
        s[left] = s[right]
        s[right] = temp
        left,right=left+1,right-1
    }
}

```