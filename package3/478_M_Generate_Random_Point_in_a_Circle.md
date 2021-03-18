This is a Math problem, nearly impossible to appear in a real interview, so there is no need to 
master it really...

Problem Description:

```
Given the radius and x-y positions of the center of a circle, write a function randPoint which generates a uniform random point in the circle.

Note:

input and output values are in floating-point.
radius and x-y position of the center of the circle is passed into the class constructor.
a point on the circumference of the circle is considered to be in the circle.
randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.
Example 1:

Input: 
["Solution","randPoint","randPoint","randPoint"]
[[1,0,0],[],[],[]]
Output: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
Example 2:

Input: 
["Solution","randPoint","randPoint","randPoint"]
[[10,5,-7.5],[],[],[]]
Output: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has three arguments, the radius, x-position of the center, and y-position of the center of the circle. randPoint has no arguments. Arguments are always wrapped with a list, even if there aren't any.

```

Below is Python Solution :

```Python

class Solution:
    def __init__(self, radius, x_center, y_center):
        self.r, self.x, self.y = radius, x_center, y_center

    def randPoint(self):
        theta = uniform(0,2*pi)
        # the 1st way to calculate R
        # R = self.r*sqrt(uniform(0,1))
        # the 2nd way to calculate R,easier to understand
        # check this link for more details : https://leetcode.com/problems/generate-random-point-in-a-circle/discuss/1113679/Python-Polar-coordinates-explained-with-diagrams-and-math/879669
        area = math.pi * self.r ** 2
        R = math.sqrt(random.uniform(0, area) / math.pi)
        return [self.x + R*cos(theta), self.y + R*sin(theta)]


```