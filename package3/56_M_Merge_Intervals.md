
Similar Problems :

```
252 Meeting Rooms
253 Meeting Rooms II
435 Non-overlapping Intervals
```

This is my Solution here :

Sort firstly and then comparing the `[end of first]` and `[start of second]`

Java

```Java

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length<=1)
            return intervals;
        
        Arrays.sort(intervals,(i1,i2)->(i1[0]==i2[0]?i1[1]-i2[1]:i1[0]-i2[0]));
        List<int[]> res = new LinkedList<>();
        
        int[] newIntervals = intervals[0];
        
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0]<=newIntervals[1]) {
                newIntervals[1] = Math.max(intervals[i][1],newIntervals[1]);
            } else {
                res.add(newIntervals);
                newIntervals = intervals[i];
            }
        }
        
        res.add(newIntervals);
        return res.toArray(new int[res.size()][]);
        
    }
}

```

---

This is another solution , it works because LinkedList add the memory :

```Java

int[] testInterval=new int[]{1,2};
result.add(testInterval);
testInterval[0]=10;
testInterval[1]=11;
System.out.println(result.get(1)[0]); // 10
System.out.println(result.get(1)[1]); // 11 Its already changed

```

```java

class Solution {
	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}
        
		return result.toArray(new int[result.size()][]);
	}
}

```

---

Python Solution :

```Python

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if len(intervals) == 0: return []
        intervals = sorted(intervals, key = lambda x: x.start)
        res = [intervals[0]]
        for n in intervals[1:]:
            if n.start <= res[-1].end: res[-1].end = max(n.end, res[-1].end)
            else: res.append(n)
        return res

```