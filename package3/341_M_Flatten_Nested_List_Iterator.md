
Problem Description:

```
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].

```

This is a typical Design Problem, what matters is to know the API and 
see how it is designed :

Solution 1 : Using Stack

```Python

# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def isInteger(self) -> bool:
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        """
#
#    def getInteger(self) -> int:
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        """
#
#    def getList(self) -> [NestedInteger]:
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        """

class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        self.stack = nestedList[::-1]
    
    def next(self) -> int:
        return self.stack.pop().getInteger()
        
    def hasNext(self) -> bool:
        while self.stack:
            current = self.stack[-1]
            if current.isInteger():
                return True
            self.stack = self.stack[:-1]+current.getList()[::-1]
        return False
         

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())

```

---

Solution 2 : using queue

```Python

class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        from collections import deque
        self.input = deque(nestedList)
    
    def next(self) -> int:
        return self.input.popleft().getInteger()
        
    def hasNext(self) -> bool:
        while self.input:
            if self.input[0].isInteger():
                return True
            current = self.input.popleft()
            self.input.extendleft(current.getList()[::-1])

```