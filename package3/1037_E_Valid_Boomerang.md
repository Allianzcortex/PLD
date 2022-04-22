
Problem description:

```
Given an array points where points[i] = [xi, yi] represents a point on the X-Y plane, return true if these points are a boomerang.

A boomerang is a set of three points that are all distinct and not in a straight line.

 

Example 1:

Input: points = [[1,1],[2,3],[3,2]]
Output: true
Example 2:

Input: points = [[1,1],[2,2],[3,3]]
Output: false
 

Constraints:

points.length == 3
points[i].length == 2
0 <= xi, yi <= 100

```

Basic idea:

这道题用数学思路解决后会更简单，可以避免许多 edge case，本质上也就是看
这三个点是否能组成三角形

如果是用计算 ratio 的方法来做的话要考虑很多特殊情况，Python 解法如下：

```Python

class Solution:
    def isBoomerang(self, points: List[List[int]]) -> bool:
        
        for index,p1 in enumerate(points):
            for p2 in points[index+1:]:
                if p1[0]==p2[0] and p1[1]==p2[1]:
                    return False
        
        points = sorted(points,key = lambda x:(x[0],x[1]))
        return self._cal_ratio(points[0],points[1])!=self._cal_ratio(points[1],points[2])
        
    
    def _cal_ratio(self,p1,p2):
        x_distance = p1[0]-p2[0]
        y_distance = p1[1]-p2[1]
        

        if y_distance == 0:
            return f"0//0"
        return x_distance/y_distance

```