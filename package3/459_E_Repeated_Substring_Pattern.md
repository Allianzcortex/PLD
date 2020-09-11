
Java Solution

The 1st type, why can we use this solution to solve it ?

```Java

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // adcacd
        // abaaba
        if(s==null || s.length()==0)
            return true;
        String ss = s + s;
        return ss.substring(1,ss.length()-1).indexOf(s)!=-1;
    }
}

```

---

Solution2 : more reasonable. Try multiple searches

```Java

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // adcacd
        // abaaba
        if(s==null || s.length()==0)
            return true;
        int len = s.length();
        for(int i=len/2;i>=1;i--) {
            if(len%i!=0)
                continue;
            int count = len/i;
            int j;
            String subStr = s.substring(0,i);
            for(j=1;j<count;j++) {
                if(!subStr.equals(s.substring(j*i,j*i+i)))
                    break;
            }
            
            if(j==count)
                return true;
        }
        
        return false;
    }
}

```