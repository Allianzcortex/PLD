
Problem description:

```
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
 

Constraints:

1 <= arr.length <= 5 * 104
0 <= arr[i] < arr.length
0 <= start < arr.length

```

Basic idea:

这道题是很有趣的一道题，基本思路是用 `BFS` 来解，把所有可能访问到的点都加入，然后
看是否有一个点的值为 0

Python 解法如下：

```Python

class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        """
        reach a value with index 0
        """
        
        visited = set()
        queue = deque([start])
        
        while queue :
            
            curr = queue.popleft()
            if arr[curr]==0:
                return True
            
            visited.add(curr)
            
            left_index,right_index = curr-arr[curr],curr+arr[curr]
            
            if left_index>=0 and left_index not in visited:
                queue.append(left_index)
            
            if right_index<=len(arr)-1 and right_index not in visited:
                queue.append(right_index)
        
        return False

```

TODO : add DFS solution && Java/Golang solution