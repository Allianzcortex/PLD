
Problem description:

```

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

```

这道题的思路很经典，就是用两个堆栈，第一个堆栈正常存储值，
第二个堆栈一直存储最小的值

Python Solution :

```Python

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        
        self.val_stack = []
        self.min_stack = []
        

    def push(self, val: int) -> None:
        
        self.val_stack.append(val)
        
        if not self.min_stack or self.min_stack[-1]>val:
            self.min_stack.append(val)
        else:
            self.min_stack.append(self.min_stack[-1])
        

    def pop(self) -> None:
        
        self.val_stack.pop()
        self.min_stack.pop()
        

    def top(self) -> int:
        
        return self.val_stack[-1]
        

    def getMin(self) -> int:
        
        return self.min_stack[-1]

```

The most classic problem

```Java

public class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack=new Stack<>();
        this.min=new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            min.push(x);
        } else {
            if(x<min.peek()){
                min.push(x); 
            }
            else{
                min.push(min.peek());
                   
            }
            stack.push(x);
        }
    }
    
    public void pop() {
        min.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

```