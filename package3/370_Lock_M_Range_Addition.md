
```
Assume you have an array of length n initialized with all 0’s and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex … endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:

Given:

    length = 5,
    updates = [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
    ]

Output:

    [-2, 0, 3, 5, 3]
Explanation:

Initial state:
[ 0, 0, 0, 0, 0 ]

After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]

After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]

After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]

```

---

The idea is : 

```
Therefore, for every (start, end, val) updates, we only need to do two operations:

arr[start] += val;
arr[end + 1] -= val;
At the end, we apply cumulative sum to the array: array[i] += array[i - 1].

For each update query (start,end,val) on the array arr, the goal is to achieve the result: arri=arri+val∀i∈[start,end].

Applying the final transformation, ensures two things:

It carries over the +val increment over to every element arri∀i≥start.
It carries over the −val increment (equivalently, a +val decrement) over to every element arrj∀j>end.

```

```Java

class Solution {
     public int[] getModifiedArray(int length,int[][] updates) {
        int[] res = new int[length];
        
        for(int[] up:updates) {
            res[up[0]] += up[2];
            if(up[1]<length-1) 
                res[up[1]+1] -= up[2];
        }
        
        for(int i=1;i<length;i++) {
            res[i] += res[i-1];
        }
        
        return res;
    }
}

```