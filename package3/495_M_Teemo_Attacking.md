

This is my solution :

calculate the interval , most intuitive one.

```Java

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        if(len == 0)
            return 0;
        
        int start = timeSeries[0];
        int end = timeSeries[0] + duration;
        int totalTime = 0;
        for(int i=1;i<len;i++) {
            int newStart = timeSeries[i];
            int newEnd = timeSeries[i] + duration;
            
            if(newStart>end) {
                totalTime += (end-start);
                start = newStart;
                end = newEnd;
            }
            else {
                end = newEnd;
            }
        }
    
        totalTime +=(end-start);
        return totalTime;
    }
}

```

The 2nd way is to calculate item one by one:

``` Java
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // [1,3] 5
        // 1 2 3 4 5 6 7 8
        // if there is no overlap , should add another duration
        // if there is overlap , should add (duration - (duration - (timeSeries[i]-timeSeries[i-1])))
        // and then equal to timeSeries[i]-timeSeries[i-1]
        if(timeSeries.length==0)
            return 0;
        int sum = duration;
        for(int i=1;i<timeSeries.length;i++) {
            sum += Math.min(timeSeries[i]-timeSeries[i-1],duration);
        }
        
        return sum;
    }
}

```

TODO : add Python solution