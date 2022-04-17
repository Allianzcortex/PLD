Problem Description :

```
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

```

did it in the past. Below is the Java solution which is so ineffective...

```Java

class CQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public CQueue() {
        this.s1=new Stack<Integer>();
        this.s2=new Stack<Integer>();
    }
    
    public void appendTail(int value) {
        this.s1.push(value);

    }
    
    public int deleteHead() {
        if(this.s1.isEmpty())
            return -1;
        while(!this.s1.isEmpty()){
            this.s2.push(this.s1.pop());
        }
        int val = this.s2.pop();
        while(!this.s2.isEmpty()) {
            this.s1.push(this.s2.pop());
        }
        return val;
    }
}

```

---

Below is the right Python Solution :

complexity analysis:



```Python

class CQueue:

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def appendTail(self, value: int) -> None:
        self.stack1.append(value)

    def deleteHead(self) -> int:
        if self.stack2:
            return  self.stack2.pop()
        else:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
            return self.stack2.pop() if self.stack2 else -1

```