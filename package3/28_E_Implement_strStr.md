
We can use KMP(advanced) to solve it.

Currently let's only use brute-force one.

```Java

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            for(int j=0;j<needle.length() && haystack.charAt(i+j)==needle.charAt(j);j++) {
                if(j==needle.length()-1)
                    return i;
            }
            
        }
         return -1;
    }
}

```

TODO add python solution #

