
Initially I want to count 0 on both x&y axis,
actually its tooo complex.

Just need to use a HashSet to store every position visited.

```Java

class Solution {
    public boolean isPathCrossing(String path) {
        int x=0,y=0;
        Set<String> set = new HashSet<>();
        set.add("0 0");
        for(char ch:path.toCharArray()) {
            if(ch=='N')
                x+=1;
            else if(ch=='S')
                x-=1;
            else if(ch=='E')
                y+=1;
            else if(ch=='W')
                y-=1;
            
            if(!set.add(x+" "+y))
                return true;
        }
        
        return false;
    }
}

```

---

This is Python solution,will add it later :

https://leetcode.com/problems/path-crossing/discuss/709569/Python-Easy-and-Fast