
The idea is to get the intersection of different areas.

```Java
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int x=m,y=n;
        for(int[] op:ops) {
            x=Math.min(op[0],x);
            y=Math.min(op[1],y);
        }
        
        return x*y;
    }
}


```