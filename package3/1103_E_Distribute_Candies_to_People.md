Just follow the logic

```Java

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        
       int[] res = new int[num_people];
        for(int i=0;candies>0;i++) {
            res[i%(num_people)] += Math.min(i+1,candies);
            candies-=(i+1);
        }
        
        return res;
    }
}
```