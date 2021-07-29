
Problem description:

```

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

```



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

sort and merge:

```Python

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        
        intervals.sort(key=lambda x:(x[0],x[1]))
        res = []
        
        index = 0
        while index < len(intervals):
            if not res or res[-1][1]<intervals[index][0]:
                res.append(intervals[index])
            else:
                prev = res.pop()
                min_ = prev[0]
                max_ = max(prev[1],intervals[index][1])
                res.append([min_,max_])
            index += 1
            
        return res

```

and based on same idea, there is another way to solve it :
only 7 lines,update the end

```Python
def merge(self, intervals):
    out = []
    for i in sorted(intervals, key=lambda i: i.start):
        if out and i.start <= out[-1].end:
            out[-1].end = max(out[-1].end, i.end)
        else:
            out += i,
    return out

```