
Problem description:

```
A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

The area of the rectangular web page you designed must equal to the given target area.
The width W should not be larger than the length L, which means L >= W.
The difference between length L and width W should be as small as possible.
Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.

 

Example 1:

Input: area = 4
Output: [2,2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
Example 2:

Input: area = 37
Output: [37,1]
Example 3:

Input: area = 122122
Output: [427,286]

```

Basic idea:

这道题其实思路很清晰，就是：

a. 如果该数开根号是整数，那么 math.sqrt(area) 就是需要的结果

b. 如果不是，那么从 int(math.sqrt(area))+1 起开始一个一个试

但因为 Python 本身判断起来有点 tricky 所以这里实现的也就...

anyway 解法如下：


```Python

import math

class Solution:
    def constructRectangle(self, area: int) -> List[int]:
    
        root = math.sqrt(area)
        
        for val in range(int(root),area+1):            
            if area%val==0:
                val1,val2 = val,area//val
                
                if val1<val2:
                    continue
                return [val1 , val2]

```