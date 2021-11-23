
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

Basic idea : Python 解法如下

先排序然后再 merge

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

对应的时间复杂度为：

time complexity: 排序需要 O(nlogn)，迭代整个数组需要 O(n)，加起来为 O(nlogn)+O(n)=O(nlogn)

space complexity: 需要一个数组来保存输出结果，best case 是 O(1)，worst case 是 O(n)，所以平均也是 O(n)，随着
input 的增加而增加

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

更新一下 Java 的解法，其中 Java 的解法更巧妙，用两个变量 `start & end` 
来存储端点值，只有在需要的时候再更新：

Java 解法如下：

```Java

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(i1,i2)->(i1[0]-i2[0]));
        
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int[] interval:intervals) {
            
            if(interval[0]<=end) {
                end = Math.max(end,interval[1]);
            } else {
                res.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
            }
        }
        
        res.add(new int[]{start,end});
        
        // 注意这里的把 List<int[]> 转换为 int[][] 非常巧妙
        return res.toArray(new int[0][0]);
        
    }
}

```