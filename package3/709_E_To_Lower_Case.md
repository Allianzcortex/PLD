Problem Description :

```
Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

 

Example 1:

Input: s = "Hello"
Output: "hello"
Example 2:

Input: s = "here"
Output: "here"
Example 3:

Input: s = "LOVELY"
Output: "lovely"
 

Constraints:

1 <= s.length <= 100
s consists of printable ASCII characters.
```

---

Solution :

Obviously we try to avoid the use of built-in function like `tolowercase()`.

We need to remember 3 very useful numbers:

- Ascii number of `A` is 65
- Ascii number of `Z` is 90
- difference between `A` and `a` is 32

Python Solution:

```Python
class Solution:
    def toLowerCase(self, s):
        return "".join(chr(ord(i) + 32) if "A" <= i <= "Z" else i for i in s)
```


```Java
class Solution {
    public String toLowerCase(String str) {
        if(str.length()==0)
            return str;
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
        if(arr[i]>='A' && arr[i]<='Z')
            arr[i]+=('a'-'A');
        }
        return new String(arr);
        
    }
}

```



Golang Solution :

```Go

func toLowerCase(s string) string {
    runs:=[]rune(s)
    diff:='a'-'A'
    
    for i:=0;i<len(runs);i++ {
        if(runs[i]>='A' && runs[i]<='Z') {
            runs[i] += diff
        }
        // or we can directly use 
        // if(runs[i]>=65 && runs[i]<=90) {
        //     runs[i]+=32
        // }
    }
    
    return string(runs)
}

```