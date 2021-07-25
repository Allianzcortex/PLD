
Problem Description:

```
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-231 <= x <= 231 - 1

```

The tricky part for this problem is that there are 
lots of corner cases,like `-+1` and we need to avoid
`integer overflow` issue.

Below is Java Solution :

```Java

class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()==0 || str.equals("-+1"))
            return 0;
        int sign=1;
        int index=0;
        int len=str.length();
        char[] arr = str.toCharArray();
        
        // 1. handle white space
        while(index<len && arr[index]==' ')
            index++;
        if(index>=len)
            return 0;
        
        // 2. handle sign
        if(arr[index]=='-') {
            index+=1;
            sign=-1;
        }
        if(index>=len)
            return 0;
        
        if(arr[index]=='+') {
            index+=1;
            sign=1;
        }
        if(index>=len)
            return 0;
        
        // calculate 
        int res=0;
        while(index<len && arr[index]<='9' && arr[index]>='0') {
            int digit=arr[index]-'0';
            // need to handle stackoverflow here
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10)) {
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res*10+digit;
            index++;
        }
        
        return res*sign;
    }
}

```

---

Next is Python Solution :

```Python

class Solution:
    def myAtoi(self, s: str) -> int:
        
        res = 0
        sign = 1
        
        index = 0
        
#         while index < len(s) and s[index]==" ":
#             index += 1
        
#         if index>=len(s):
#             return res  # handle empty character ""
        
        s = s.lstrip()
        if s=="":
            return 0
        
        if s[index] == "-":
            sign = -1
            index += 1
        elif s[index] == '+':
            index += 1
        
        while index <len(s):
            ch = s[index]
            
            if not ch.isdigit():
                break
            else:
                res = res*10 + int(ch)
                index += 1
        
        res = res*sign 

        if res<(-2)**31:
            return (-2)**31
        
        if res>2**31-1:
            return 2**31-1
        
        return res

```

