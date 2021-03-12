Problem Description:

```
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
```

Below is the standard 2-pointers solution,
time coplexity:O(N)
space complexity:O(N) , N is the length of array

```java

class Solution {
    public String replaceSpace(String s) {
        if(s==null || s.length()==0)
            return s;
        int spaceCount = 0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)==' ')
                spaceCount+=1;
        char[] res=new char[s.length()+spaceCount*2];
        for(int i=s.length()-1,j=res.length-1;i>=0;i--) {
            if(s.charAt(i)==' ') {
                // insert 20%
                res[j--]='0';
                res[j--]='2';
                res[j--]='%';
            } else {
                res[j--]=s.charAt(i);
            }
        }

        return String.valueOf(res);
    }
}

```

While below is Python solution : just for fun

```python

class Solution:
    def replaceSpace(self, s: str) -> str:
        # res = ""
        # for char in s:
        #     if char is ' ':
        #         res += "%20"
        #     else:
        #         res += char
        # return res
        return s.replace(" ","%20")
```