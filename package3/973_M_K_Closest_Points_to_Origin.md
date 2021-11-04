
Problem description:

```

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104

```

Basic idea:

求问 `kth` 之类的问题标准思路，三种解法：

1. 排序：

```Python

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        sorted_points = sorted(points,key=lambda x:math.sqrt(x[0]**2+x[1]**2))
        
        return sorted_points[:k]

```

2. 最大堆：时间复杂度为 O(NlogK)

```Python

from heapq import heappush,heappop

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        queue = []
        for point in points:
            dist = math.sqrt(point[0]**2+point[1]**2)
            heappush(queue,(-1*dist,(point[0],point[1])))
            
            if len(queue)>k:
                heappop(queue)
        
        return [[p[1][0],p[1][1]] for p in queue ]

```

3. quick-select : 

这里就还是套用模板了，不过要注意因为要求的是 kth closest points，本质上要做的是 kth smallest points

时间复杂度为 O(N)

Python 解法如下：

```Python

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        self.quick_select(points,0,len(points)-1,k)
        
        print(points)
        
        return points[:k]
    
    def quick_select(self,points,left,right,k):
        """
        2,1,3,4,5,6
              _
        """
        if left>=right:
            return
        
        index = self.find_pivot(points,left,right,k)
        if index+1==k:
            return 
        elif index+1>k:
            self.quick_select(points,left,index-1,k)
        else:
            self.quick_select(points,index+1,right,k)
        
    
    def find_pivot(self,points,left,right,k):
        
        def _get_distance(point):
            return abs(point[0])**2+abs(point[1])**2
        
        pivot = points[left]
        target = _get_distance(pivot)
        
        while left<right:
            while left<right and _get_distance(points[right])>=target:
                right -= 1
            points[left] = points[right]
            
            while left<right and _get_distance(points[left])<=target:
                left += 1
            points[right] = points[left]
            
            points[left],points[right] = points[right],points[left]
        
        points[left] = pivot
        return left

```