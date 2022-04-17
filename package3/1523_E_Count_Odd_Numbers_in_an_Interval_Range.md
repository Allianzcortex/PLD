
My solution:

```Java

class Solution {
    public int countOdds(int low, int high) {
        /**
        9 10 11 12 13 14 15
        **/
        int res = 0;
        if(low>high)
            return 0;
        if(low%2==1) {
            res+=1;
            low+=1;
        }
        if(high%2==1) {
            res+=1;
            high-=1;
        }
        
        return (high-low)/2+res;
    }
}

```

Some other tricky ones

Because 

> the count of odd numbers between 1 and low - 1 is low / 2
the count of odd numbers between 1 and high is (high + 1 ) / 2


```Java

 public int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }

```