
Problem description:

```

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

```

Idea:

这道题就是有先后顺序的课程，思路是用 BFS 的拓扑排序：

1. 比如有一个连接：i->j ，它的意思是要先完成 i 才能完成 j，那么我们做两件事

a. `dependencies[i].append(j)` 把 j 加入 i 的下一个任务列表里

b. `indegrees[j] += 1` 因为有一个元素指向 j ，所以 j 的入度要 + 1

2. 然后找出所有入度为 0 的点

3. 根据 2 里的点然后依据 dependencies 展开，依次把对应节点的入度 - 1，然后如果
发现某个节点的入度为 0，那么可以依此类推再重复 3 的操作

---

Python 代码如下：

```Python

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        # 1. build dependencies and indegrees
        
        dependencies = [[] for _ in range(numCourses)]
        indegrees = [0]*numCourses
        
        for i,j in prerequisites:
            # finish j , then we can finish i
            indegrees[i] += 1
            dependencies[j].append(i)
        
        # start from courses where indegree is 0
        queue = deque([i for i in range(numCourses) if indegrees[i]==0])
        count = 0
        
        while queue:
            curr = queue.popleft()
            count += 1
            
            for des in dependencies[curr]:
                indegrees[des] -= 1
                if indegrees[des] == 0:
                    queue.append(des)
        
        return count==numCourses

```