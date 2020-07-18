
```Java

class Solution {
    public int[] printNumbers(int n) {
        int base=0;
        int max=0;
        for(int i=0;i<n;i++) {
            max+=(9*Math.pow(10,i));
        }
        int[] res=new int[max];
        for(int i=0;i<max;i++)
            res[i]=i+1;
        return res;
    }
}

```

Do we have a better solution ?