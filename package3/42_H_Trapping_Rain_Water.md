
Problem Description:

```

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

```

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

Below is Python solution :

这道题的思路是这样的：

对左边的墙，从左往右遍历，当发现一堵墙小于它左边的高度时，就说明在这堵墙的竖直
水平上可以存储 (maxLeft-height[left]) 容量的水。把所有墙能存储的水加起来就是
总的容量。

对右边的墙，则是从右往左遍历。

```Python
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        left,right = 0,len(height)-1
        max_left,max_right = 0,0
        res = 0
        
        while left<right:
            # case 1
            if height[left]<height[right]:
                if height[left]>max_left:
                    max_left = height[left]
                else:
                    res += (max_left-height[left])
                left += 1
            
            else:
                
                if height[right]>max_right:
                    max_right = height[right]
                else:
                    res += (max_right-height[right])
                right -= 1
        
        return res

```
