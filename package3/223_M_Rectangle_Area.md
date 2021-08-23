
Problem description:

```

Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.

The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).

The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

 

Example 1:

Rectangle Area
Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
Output: 45
Example 2:

Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
Output: 16

```

Idea :

思路其实很明确，就是 area1 和 area2 的距离很好算，但重叠部分的话，比如对 x 轴，
就是两个矩形最小的右边 - 两个矩形最大的左边，y 轴也是类似，然后有重叠部分的话
要在计算后减去一个重叠的面积

---

Python Solution :

```Python

class Solution:
    def computeArea(self, ax1: int, ay1: int, ax2: int, ay2: int, bx1: int, by1: int, bx2: int, by2: int) -> int:
        
        area1 = (ax2-ax1)*(ay2-ay1)
        area2 = (bx2-bx1)*(by2-by1)
        
        # check whether overlap
        overlapWidth = min(ax2,bx2)-max(ax1,bx1)
        overlapHeight = min(ay2,by2)-max(ay1,by1)
        
        if overlapWidth<=0 or overlapHeight<=0:
            overlap = 0
        else:
            overlap = overlapWidth * overlapHeight
        # if bx1>=ax2 or ay1>=by2:
        #     overlap = 0
        # else:
        #     overlap = (ax2-bx1)*(by2-ay1)
        
        return area1+area2-overlap

```