The similar structure as finding the non-overlap

Key is to find all the possible problems...

To think why shooting at right provides the best chance

```Java
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0)
            return 0;
        
        // [1,6] [2,8] [7,12] [10,16]
        Arrays.sort(points,(a,b)->(a[1]-b[1]));
        int cnt = 1;
        int end = points[0][1];
        for(int i=1;i<points.length;i++) {
            if(points[i][0]<=end)
                continue;
            cnt+=1;
            end = points[i][1];
        }
        
        return cnt;
    }
}
```