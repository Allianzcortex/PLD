
Classic Two-Pointer Solution

```Java
class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1;
        int maxLeft=0,maxRight=0;
        int res = 0;
        while(left<right) {
            if(height[left]<=height[right]) {
                if(height[left]>maxLeft) {
                    maxLeft = height[left];
                } else {
                    res+=(maxLeft-height[left]);
                }
                left+=1;
            } else {
                if(height[right]>maxRight) {
                    maxRight = height[right];
                } else {
                    res+=(maxRight-height[right]);
                }
                right-=1;
            }
        }
        
        return res;
    }
}

```