
Should be one-time bug free

```Java
class MinStack {
    
    private Stack<Integer> s1;
    private Stack<Integer> s2; // used to store min value
    public MinStack() {
        this.s1=new Stack<Integer>();
        this.s2=new Stack<Integer>();
    }
    
    public void push(int x) {
        this.s1.push(x);
     
        if(this.s2.isEmpty() || x<this.s2.peek())
            this.s2.push(x);
        else
            this.s2.push(this.s2.peek());
    }
    
    public void pop() {
        this.s1.pop();
        this.s2.pop();
    }
    
    public int top() {
        return this.s1.peek();
    }
    
    public int min() {
        return this.s2.peek();
    }
}

```