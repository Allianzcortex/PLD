
My Java Solution:

There should be a math solution to return the result in O(1) time

```Java
class Solution {
    public int minOperations(int n) {
        /**
        [1,3,5,7,9,11]
        
        **/
        int sum = 0;
        int res = 0;
        for(int i=0;i<n;i++)
            sum+=((2*i)+1);
        int average = sum/n;
        for(int i=0;i<n/2;i++)
            res+=(average-2*i-1);
        
        return res;
    }
}

```