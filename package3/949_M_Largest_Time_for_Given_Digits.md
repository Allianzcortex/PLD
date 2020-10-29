

There are multiple soultions(permutations) based on :

https://leetcode.com/problems/largest-time-for-given-digits/solution/

I need to check all of them later.

Currently Java Solution :


```Java

class Solution {
    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        for(int i=3;i>=0;i--) {
            for(int j=3;j>=0;j--) {
                for(int k=3;k>=0;k--) {
                    if(i==j || i==k || j==k)
                        continue;
                    String res = generateTime(arr,i,j,k,6-i-j-k);
                    if(!res.equals(""))
                        return res;
                }
            }
        }
        
        return "";
    }
    
    public String generateTime(int[] A,int i,int j,int k,int l) {
       
        int hour = 10*(A[i])+(A[j]);
        int min = 10*(A[k])+(A[l]);
        if(hour>23)
            return "";
        if(min>59)
            return "";
        return String.format("%02d:%02d",hour,min);
    }
}

```

TODO : add more solutions & Python solution