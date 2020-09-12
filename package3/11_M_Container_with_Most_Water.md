
```java

class Solution {
    public int maxArea(int[] height) {
        int left=0,right = height.length-1;
        int maxRes = 0;
        
        while(left<right) {
            int temp = (right-left)*Math.min(height[left],height[right]);
            if(temp>maxRes)
                maxRes = temp;
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        
        return maxRes;
    }
}

```

We can find one way to prove it :

