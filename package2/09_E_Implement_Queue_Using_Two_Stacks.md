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