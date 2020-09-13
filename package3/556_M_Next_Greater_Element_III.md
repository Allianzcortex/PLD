

TODO Add Java Solution

The logic is like change str to int and `next permutation`.

```Python

class Solution:
    def nextGreaterElement(self, n: int) -> int:
        res = [int(s) for s in str(n)]
        index = -1
        for i in range(0,len(res)-1):
            if(res[i]<res[i+1]):
                index = i
       
        if(index == -1):
            return -1
        index2 = -1
        for i in range(len(res)-1,-1,-1):
            if(res[i]>res[index]):
                index2 = i
                break
        res[index],res[index2] = res[index2],res[index]
        res[index+1:] = res[-1:index:-1]
        output = 0
        for item in res:
            output = output*10 + item
        if(output>=2**31):
            return -1
        return output
```

and an elegant Python solution:

we can compare char directly, no need to convert it into int again.

```Python

class Solution:
    def nextGreaterElement(self, n: int) -> int:
        s = list(str(n))
        i1 = len(s)-2
        while(i1>=0 and s[i1]>=s[i1+1]):
            i1-=1
        if(i1==-1):
            return -1
        i2 = len(s)-1
        while(i2>i1 and s[i2]<=s[i1]):
            i2-=1
        
        s[i1],s[i2] = s[i2],s[i1]
        res = int(''.join(s[:i1+1]+s[i1+1:][::-1]))
        if(res>=2**31):
            return -1
        return res;

```