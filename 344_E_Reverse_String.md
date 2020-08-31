
As easy as 1+1:

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