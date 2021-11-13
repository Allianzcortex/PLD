
Problem description:

```

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 

Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100

```

Basic idea:

这道题要在 O(N) 时间复杂度内找出前一个的最大值

核心思想是：

`Store currently unsolved elements, later if there is a bigger number, withdraw the unsolved elements and get the answer.`

Python 解法如下：

```Python

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        length = len(temperatures)
        res = [0]*length
        
        stack = []
        
        for index,value in enumerate(temperatures):
            while (stack and stack[-1][-1]< value):
                prev_index,_ = stack.pop()
                res[prev_index] = index-prev_index;
            
            stack.append((index,value))
        
        return res

```

Very classic Stack problem , just like next greater element

```Java

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i=0;i<T.length;i++) {
            while(!stack.isEmpty() && T[stack.peek()]<T[i]) {
                int j = stack.pop();
                // res[stack.pop()] = i-stack.peek();
                res[j] = i-j;
        }
            stack.push(i);
        }

        return res;
    }
}

```