
Problem description:

```
Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

 

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
 

Constraints:

1 <= pushed.length <= 1000
0 <= pushed[i] <= 1000
All the elements of pushed are unique.
popped.length == pushed.length
popped is a permutation of pushed.

```

Basic idea:

这是一道非常经典和高频的题目
按照 pushed 的顺序来压入数字，然后发现如果压入的数字等于 poped() 的当前序列
然后就一直弹出

Mock the stack behaviour

Python 解法如下：

```Python

class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack = []
        index = 0
        for i in range(len(pushed)):
            
            stack.append(pushed[i])
            
            while stack and stack[-1]==popped[index]:
                stack.pop()
                index += 1
        
        return not stack

```

Java 解法如下：

```Java

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null || popped==null || pushed.length!=popped.length)
            return false;
        
        Stack<Integer> s = new Stack<>();
        int index = 0;
        
        for(int i=0;i<pushed.length;i++) {
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek()==popped[index]) {
                s.pop();
                index+=1;
            }
        }
        
        return s.isEmpty();
    }
}

```