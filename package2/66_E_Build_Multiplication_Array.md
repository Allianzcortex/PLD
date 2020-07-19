
```Java

class Solution {
    public int[] constructArr(int[] a) {
        /**
          0 1 2 3 4
        0 1 x x x x
        1 x 1 x x x
        2 x x 1 x x
        3 x x x 1 x
        4 x x x x 1

        **/
        if(a==null || a.length==0)
            return new int[]{};
        int[] b = new int[a.length];
        b[0] = 1;
        // calculate left-bottom triangle
        for(int i=1;i<a.length;i++) {
            b[i]=b[i-1]*a[i-1];
        }

        int temp = 1;
        // calculate right-top triangle
        for(int i=a.length-2;i>=0;i--) {
            temp*=a[i+1];
            b[i]*=temp;
        }

        return b;
    }
}

```