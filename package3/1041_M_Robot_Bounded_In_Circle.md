
Problem description:

```

On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.
Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

Constraints:

1 <= instructions.length <= 100
instructions[i] is 'G', 'L' or, 'R'.

```

Basic idea:

这道题是自己看 hint 以后做出来的，简而言之就是经过一轮迭代后，如果 robot 满足如下
两个条件之一那么就意味着它是在 circle 里：

```
条件 1: 返回到原来的坐标 (0,0)

条件 2: 反向不再朝北
```

AC 代码如下，但关键的还是证明...

```Python

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        """
        The robot stays in the circle if :
        a. it goes back to the original point
        b. the direction if changed
        
        """
        x,y = 0,0
        direc = 0 # 0->up 1->left 2->down 3->right
        
        for move in instructions:
            if move=='L':
                direc = (direc+1)%4
            elif move=='R':
                direc = (4+direc-1)%4
            else:
                if direc==0:
                    y+=1
                elif direc==1:
                    x-=1
                elif direc==2:
                    y-=1
                else:
                    x+=1

        return (x==0 and y==0) or direc!=0

```