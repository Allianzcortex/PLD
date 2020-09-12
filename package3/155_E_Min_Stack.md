
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