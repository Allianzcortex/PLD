
We sort the intervals based on end and find the expected non-overlapping intervals.

Then we use the whole length to minus the result of 1st step to know how many intervals we should remove.

```Java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null || intervals.length==0)
            return 0;
        Arrays.sort(intervals,(a,b)->(a[1]-b[1]));
        int cnt = 1;
        int end=intervals[0][1];
        
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0]<end)
                continue;
            end = intervals[i][1];
            cnt += 1;
        }
        
        return intervals.length - cnt;
    }
}

```