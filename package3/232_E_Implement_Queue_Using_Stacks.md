
Idea :

This problem should be pretty straightforward.
There are multiple solutions,I will choose the following one :

---

Java Solution:

This is the most intuitive way,however there are two parts that can be optimized :

a. code in `pop()` and `peek()` are duplicated, we should be able to find one way to simplify it.
b. code logic is not optimized when you need to `pop()/peek()` continually

```Java

class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    
    public MyQueue() {
        this.s1 = new Stack<Integer>();
        this.s2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!this.s1.isEmpty()) {
            this.s2.push(this.s1.pop());
        }
        
        int elem = this.s2.pop();
        
        while(!this.s2.isEmpty()) {
            this.s1.push(this.s2.pop());
        }
        
        return elem;
        
    }
    
    /** Get the front element. */
    public int peek() {
        while(!this.s1.isEmpty()) {
            this.s2.push(this.s1.pop());
        }
        
        int elem = this.s2.peek();
        
        while(!this.s2.isEmpty()) {
            this.s1.push(this.s2.pop());
        }
        
        return elem;
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        return this.s1.isEmpty();
    }
}
```

So the optimzied one will be :

```Java

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    public MyQueue() {
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        s1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       if(!s2.isEmpty()) {
           return s2.pop();
       } else {
           while(!s1.isEmpty()) {
               s2.push(this.s1.pop());
           }
           return s2.pop();
       }
    }
    
    /** Get the front element. */
    public int peek() {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        
        return s2.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        return s1.isEmpty() && s2.isEmpty();
    }
}

```

Python Solution :

```Python

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.s1,self.s2 = [],[]
        

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.s1.append(x)
        
    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        if len(self.s2)!=0:
            return self.s2.pop()
        else:
            while(len(self.s1)!=0):
                self.s2.append(self.s1.pop())
            return self.s2.pop()

    def peek(self) -> int:
        """
        Get the front element.
        """
        if len(self.s2)!=0:
            return self.s2[-1]
        else:
            while(len(self.s1)!=0):
                self.s2.append(self.s1.pop())
            return self.s2[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return len(self.s1)==0 and len(self.s2)==0
```