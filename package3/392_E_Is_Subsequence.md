This is a very interesting problem.

Multiple approaches : Greedy / DP / Two Pointers.

I will provide some solutions here : 

Solution 1 : Greedy

```Java

class Solution {
    public boolean isSubsequence(String s, String t) {
        int index=-1;
        for(char ch:s.toCharArray()) {
            index = t.indexOf(ch,index+1);
            if(index==-1)
                return false;
        }
        return true;
    }
}

```

Solution 2 : Two Pointer

```Java
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }
}

```

More Solutions will be added later.