
Problem description:

```

You are given coordinates, a string that represents the coordinates of a square of the chessboard. Below is a chessboard for your reference.



Return true if the square is white, and false if the square is black.

The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number second.

 

Example 1:

Input: coordinates = "a1"
Output: false
Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.
Example 2:

Input: coordinates = "h3"
Output: true
Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.
Example 3:

Input: coordinates = "c7"
Output: false
 

Constraints:

coordinates.length == 2
'a' <= coordinates[0] <= 'h'
'1' <= coordinates[1] <= '8'

```

Basic Idea:

这道题就是很典型的二分法，1/3/5 列的结果一样，2/4/6 列的结果一样

Python 解法如下：

```Python

class Solution:
    def squareIsWhite(self, coordinates: str) -> bool:
        column_index = 0
        color = ''
        row = int(coordinates[1])
        if coordinates[0] in 'aceg':
            column_index = 0
            color = 'black' if row%2==1 else 'white'
        else:
            column_index = 1
            color = 'white' if row%2==1 else 'black'
        
        return color=='white'

```

