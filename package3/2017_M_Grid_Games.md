
Problem description:

```

You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. Two robots are playing a game on this matrix.

Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).

At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.

The first robot wants to minimize the number of points collected by the second robot. In contrast, the second robot wants to maximize the number of points it collects. If both robots play optimally, return the number of points collected by the second robot.

 

Example 1:


Input: grid = [[2,5,4],[1,5,1]]
Output: 4
Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
The cells visited by the first robot are set to 0.
The second robot will collect 0 + 0 + 4 + 0 = 4 points.
Example 2:


Input: grid = [[3,3,1],[8,5,2]]
Output: 4
Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
The cells visited by the first robot are set to 0.
The second robot will collect 0 + 3 + 1 + 0 = 4 points.
Example 3:


Input: grid = [[1,3,1,15],[1,3,3,1]]
Output: 7
Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
The cells visited by the first robot are set to 0.
The second robot will collect 0 + 1 + 3 + 3 + 0 = 7 points.

```

Basic idea:

自己一开始也注意到了因为只有 2 行，所以一旦向下走后就只能向右走，然后之后就困在 DFS 的逻辑里无法出来，
类似这样：

```Python

    def dfs(self,grid,x,y,path,res):
        if y>len(grid[0]):
            return
        
        path.add((x,y))
        if x==1 and y==len(grid[0])-1:
            res.append(path)
        if x==0:    
            self.dfs(grid,x+1,y,path)
            self.dfs(grid,x,y+1,path)
            
        if x==1:
            self.dfs(grid,x,y+1)
```

这道题有点偏向博弈论的感觉，也就是第一个要最小化第二个的 points，第二个则要最大化 points.

所以这道题更偏向找规律，用 `topSum` 来表示 `sum(grid[0])`，
来举个例子：

```
1 2 3 4
5 6 7 8
```

如果第一个机器第一步就是向下走，然后向右走；那么对第二个机器，
因为第一个机器走的路径都已经清 0，那么本质上能走的路径就两个：

a) 一直向右走，到最后再向下。积分为 topSum-grid[0][0]
b) 直接向下走，然后一直向右。积分为 0

---

然后如果第一个机器第一步是向右走，然后向下走，再之后所有的都是向右走，那么也因为路径已经清 0，那么本质上能走的路径就两个：

a) 一直向右走，到最后再向下。积分为 topSum-grid[0][0]-grid[0][1]
b) 直接向下走，然后一直向右。积分为 0+grid[1][0]

依次循环，按照 prefix sum 的思路，解法如下：

注意对 `min(res,max(topSum,bottomSum))` :

里面的 `min` 是对第一个机器来说的，因为第一个机器要让
第二个机器的积分最小

里面的 `max` 是对第二个机器来说的，因为第二个机器要让
自己的积分最高

```Python

class Solution:
    def gridGame(self, grid: List[List[int]]) -> int:
        """
        For the 1st robot : go right | go down.
        
        """
        column = len(grid[0])
        topSum = sum(grid[0])
        bottomSum = 0
        res = float('inf')
        
        for i in range(column):
            topSum -= grid[0][i]
            res = min(res,max(topSum,bottomSum))
            bottomSum += grid[1][i]
            
        return res

```