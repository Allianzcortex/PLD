
Problem Description:

```
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0). 

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:  
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
Note:

1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
The number of keys in all rooms combined is at most 3000.

```

The problem description is very clear already : 

We can use DFS / BFS to find all possible rooms :

Python DFS Solution :

```Python
class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        
        visited = set()
        
        def dfs(num):
            if num not in visited:
                visited.add(num)
                for n in rooms[num]:
                    dfs(n)
        
        dfs(0)
        return len(visited) == len(rooms)

```

---

Python BFS Solution :

```Python

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        # This should be a classic DFS solution
        """
        Input: [[1,3],[3,0,1],[2],[0]]
        Output: false
        Explanation: We can't enter the room with number 2.
        """
        keys = [0]
        visited = set(keys)
        
        # [[2,3],[],[2],[1,3,1]]
        while keys:
            # size = len(keys)
            # for index in range(size):
            #     key = keys.pop(0)
            #     # if not visited[key]:
            #     if key not in res:
            #         keys.extend(rooms[key])
            #         res.add(key)
            #         # visited[key] = True
            key = keys.pop(0)
            for k in rooms[key]:
                if k not in visited:
                    visited.add(k)
                    keys.append(k)
                    if len(visited) == len(rooms):
                        return True
        
        return len(visited) == len(rooms)
        
        

```