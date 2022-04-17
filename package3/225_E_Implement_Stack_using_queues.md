
Problem description:

```

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, top, and empty.
All the calls to pop and top are valid.
 

Follow-up: Can you implement the stack using only one queue?

```

Basic idea:

这道题就是要用 `Queue` 来实现 `Stack` 队列

基本思路就是在 `pop` 时先 pop & append 出前 n-1 个数，然后再 pop 出的数就是需要的结果

Python 解法如下：

```Python

class MyStack:

    def __init__(self):
        
        self.queue = deque()

    def push(self, x: int) -> None:
        
        self.queue.append(x)

    def pop(self) -> int:
        
        size = len(self.queue)-1
        
        for _ in range(size):
            self.queue.append(self.queue.popleft())
        
        return self.queue.popleft()

    def top(self) -> int:
        
        return self.queue[-1]

    def empty(self) -> bool:
        
        return len(self.queue)==0

```

Java 解法如下：

```Java

class MyStack {

    private Queue<Integer> q1 = new LinkedList<Integer>();
    private int top;

    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        for(int i=1;i<q1.size();i++)
            q1.add(q1.poll());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

```