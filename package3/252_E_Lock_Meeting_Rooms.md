
Problem :

```
Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... , determine if a person could attend all meetings.

For example,
Given [ [0, 30], [5, 10], [15, 20] ],
return false.
```

The idea is pretty straight-forward. We sort the array and 
compare one time with next time.

Java Solution : Not Validated Yet

```java
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals,(o1,o2)->(o1[0]-o2[0]));
        for(int i=0;i<intervals.length-1;i++)
            if(intervals[i+1][0]<intervals[i][1])
                return false;
        return true
    }
}

```