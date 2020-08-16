
Java Solution

```Java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]%2==0)
                arr[i]=0;
            else
                arr[i]=1;
        }
        
        for(int i=0;i<=arr.length-3;i++) {
            if(arr[i]==1 && arr[i+1]==1 && arr[i+2]==1)
                return true;
        }
        
        return false;
    }
}

```

Or another 1-round solution : 

```Java

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]%2==0)
                cnt=0;
            else {
                if(++cnt==3)
                    return true;
            }
        }
        return false;
    }
}


```