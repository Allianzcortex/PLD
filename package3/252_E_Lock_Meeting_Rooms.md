
Problem :

```
Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... , determine if a person could attend all meetings.

For example,
Given [ [0, 30], [5, 10], [15, 20] ],
return false.
```

Basic idea:

很简单的方法，直接排序之后依次比较前一个的结束时间和后一个的开始时间

The idea is pretty straight-forward. We sort the array and 
compare one time with next time.

Java 解法如下：

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

Python 解法如下：

```Python

def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
    new_intervals = sorted(intervals,key=lambda x:x[0])

    for i in range(1,len(new_intervals)):
        if new_intervals[i-1][1]>new_intervals[i][0]:
            return False
    
    return True

```