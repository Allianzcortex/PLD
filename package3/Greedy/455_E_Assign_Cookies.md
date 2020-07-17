
Solution 1 : Traditional Sort & Count, need to be careful about the break condition

```Java

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for(int i=0,j=0;i<g.length && j<s.length;) {
            if(g[i]<=s[j]){
                count+=1;
                i++;
                j++;
            } else {
                j++;
            }
        }
        
        return count;
    }
}


```