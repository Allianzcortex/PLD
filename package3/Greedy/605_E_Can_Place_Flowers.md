The idea is to use greedy algorithm to get as many
empty locations as possible.

This is my initial (stupid & spaghetti code)
Not cover many cases so should add so many conditions...

```Java

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt=0;
        for(int i=0;i<flowerbed.length;i++) {
            if(cnt==n)
                return true;
            if (flowerbed[i]!=0)
                continue;
            if(i==0 && (i==flowerbed.length-1 || flowerbed[i+1]==0)) {
                cnt+=1;
                flowerbed[i]=1;
            } else if(i==flowerbed.length-1 && flowerbed[i-1]==0) {
                cnt+=1;
                flowerbed[i]=1;
            } else if(i-1>=0 && i+1<=flowerbed.length-1 && flowerbed[i-1]==0 && flowerbed[i+1]==0) {
                cnt+=1;
                flowerbed[i]=1;
            }
    }
       
        return cnt==n;
}
}


```

There is a better solution : 


