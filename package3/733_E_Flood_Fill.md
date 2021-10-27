
Problem description:

```

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.

 

Example 1:


Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
 

Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], newColor < 216
0 <= sr < m
0 <= sc < n

```

Basic idea:

很简单的 `dfs` 题目，关键是在意识到 `image[sr][sc]==newColor` 时就不需要进行下一步操作了，
Python 代码如下：

```Python

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        if image[sr][sc]==newColor:
            return image
        
        self.traverse(image,sr,sc,image[sr][sc],newColor)
        return image
    
    def traverse(self,image,x,y,oldColor,newColor):
        
        if x<0 or x>len(image)-1 or y<0 or y>len(image[0])-1:
            return
        
        if image[x][y]!=oldColor:
            return
        
        image[x][y]=newColor
        for i,j in [(1,0),(-1,0),(0,1),(0,-1)]:
            self.traverse(image,x+i,y+j,oldColor,newColor)

```