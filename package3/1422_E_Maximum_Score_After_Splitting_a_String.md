


How can this be my initial solution....oh my gosh

failed solution :

```Java

class Solution {
    public int maxScore(String s) {
        
        if(s==null || s.length()==0)
            return 0;
        int res = 0;
        int[] leftZeroes = new int[s.length()+1];
        int[] rrightOnes = new int[s.length()+1];
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='0')
                leftZeroes[i+1]=leftZeroes[i]+1;
            else
                rightOnes[]
        }
    }
}

// I'm totally a dumb

```

---


AC Java Solution :

```java

class Solution {
    public int maxScore(String s) {
        int leftZeroes=0,ones=0;
        int res = 0;
        
        for(char ch:s.toCharArray())
            if(ch=='1')
                ones++;
        
        // take care,not empty left/right substring is allowed
        // so it must be `i<s.length()-1` rather than `i<s.length`
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i)=='0')
                leftZeroes++;
            else
                ones--;
            
            res = Math.max(res,leftZeroes+ones);
        }
        
        return res;
    }
}

```

---


And another way to simplify the function based on equation :

  leftzero + rightone
= leftzero -leftone + leftone + rightone
= (leftzero-leftone) + (sum one)

So we just need to get the `max(leftzero-leftone)`

```java

class Solution {
    public int maxScore(String s) {
        int leftZeroes=0,leftOnes=0;
        int res = Integer.MIN_VALUE;
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='0')
                leftZeroes++;
            else
                leftOnes++;
            
            if(i<s.length()-1)
                res = Math.max(res,leftZeroes-leftOnes);
        }
        
        return res+leftOnes;
    }
}

```