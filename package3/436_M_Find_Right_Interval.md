
This is a very classic two-pointer problem

1. Use TreeSet which is sorted already

```Java

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int len = intervals.length;
        for(int i=0;i<len;i++) {
            map.put(intervals[i][0],i);
        }
        int[] output = new int[len];
        for(int i=0;i<len;i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            output[i] = key==null ? -1 : map.get(key);
        }
        
        return output;
    }
}


```

2. Use Two Pointers, use Map to store the index 
for there will be no duplicated index

```Java

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        // 1,2  2,3  3,4
        
        int len = intervals.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++) {
            map.put(intervals[i][0],i);
        }
        
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int[] output = new int[len];
        Arrays.fill(output,-1);
        for(int i=0;i<len;i++) {
            int left = i + 1;
            int right = len -1;
            while(left<=right) {
                int mid = left+(right-left)/2;
                if(intervals[mid][0]<intervals[i][1])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            
            
            if(left<len && intervals[i][0]<=intervals[left][0])
                output[map.get(intervals[i][0])] = map.get(intervals[left][0]);
        }
        
        return output;
    }
}

```

---

Python solution : implement two-pointer

```Python
class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        s=sorted([(x[0],i) for i,x in enumerate(intervals)],key=lambda x:x[0])
        l = len(intervals)
        res = [-1]*l
        
        for i in range(l):
            left = 0
            right = l -1
            while(left<=right):
                mid = left+(right-left)//2
                if(s[mid][0]<intervals[i][1]):
                    left = mid+1
                else:
                    right = mid-1
            if(left<l and intervals[i][1]<=s[left][0]):
                res[i] = s[left][1]
              
        return res
```