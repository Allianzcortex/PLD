
Problem description:

```
Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

For example, inverting [0,1,1] results in [1,0,0].
 

Example 1:

Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 

Constraints:

n == image.length
n == image[i].length
1 <= n <= 20
images[i][j] is either 0 or 1.

```

Basic idea:

这道题自己一开始思路是 Mock:先交换再反转

但实际上，如果 left 和 right 的值不相等的话，无论是
`0 1` 还是 `1 0`，交换再反转后都等于原值，所以我们只
需要反转 arr[left]==arr[right] 的情况

Python 代码如下：

```Python

class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        
        row,column = len(image),len(image[0])
        
        for i in range(row):
            left,right = 0,column-1
            
            while left<=right:

                # 思路 1:Mock
                # image[i][left],image[i][right] = image[i][right],image[i][left]
                # image[i][left]=1 if image[i][left]==0 else 0
                # if left!=right:
                #     image[i][right]=1 if image[i][right]==0 else 0
                
                # 思路 2:比较后再 flip
                if image[i][left]==image[i][right]:
                    image[i][left]=image[i][right]=image[i][left]^1
                
                left+=1
                right-=1
        
        return image


```

