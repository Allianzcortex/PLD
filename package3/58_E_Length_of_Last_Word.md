
This is my solution :

```Java

class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0)
            return 0;
        int right=s.length()-1;
        char[] arr = s.toCharArray();
        while(right>=0 && arr[right]==' ')
            right -= 1;
        if(right==-1)
            return 0;
        int left = right;
        while(left>=0 && arr[left]!=' ')
            left -=  1;
        return right-left;
    }
}
```

Other one-line solution :

```Java

public int lengthOfLastWord(String s) {
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
}

```

Python

```Python

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        return 0 if len(s.split())==0 else len(s.split()[-1])
        

```