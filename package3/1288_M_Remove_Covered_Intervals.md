
This is the key test case :

```
Input: intervals = [[1,2],[1,4],[3,4]]
Output: 1

```

[1,2] is covered by [1,4],and [3,4] is covered by [1,4].
So the key is how to sort.

---

```Java

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals==null || intervals.length==0)
            return 0;
        
        int res = 0;
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        
        int left=-1,right=-1;
        
        for(int[] num:intervals) {
            if(num[0]>left && num[1]>right) {
                res+=1;
                left=num[0];
            }
            right = Math.max(right,num[1]);
        }
        
        return res;
    }
}

```

---

Another solution is to sort based on left first,and if left is equal,
then sort based on right from big to small.

```Java

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals==null || intervals.length==0)
            return 0;
        
        int res = 0;
        Arrays.sort(intervals,(a,b)->(a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));
        
        int right=-1;
        
        for(int[] num:intervals) {
            if(num[1]>right) {
                res+=1;
                right=num[1];
            }
        }
        
        return res;
    }
}

```