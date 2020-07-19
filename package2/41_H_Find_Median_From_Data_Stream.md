
```Java

class MedianFinder {

    private PriorityQueue<Integer> keepBigHeap;
    private PriorityQueue<Integer> keepSmallHeap;

    public MedianFinder() {
        // If there are odd values,we can store it into either keepSmallHeap 
        // or in keepBigHeap,just make sure return the correct one.
        this.keepBigHeap = new PriorityQueue<>();
        this.keepSmallHeap = new PriorityQueue<>((a,b)->(b-a));
    }
    
    public void addNum(int num) {
        if(this.keepSmallHeap.size()!=this.keepBigHeap.size()) {
            // add odd,should be stored in keepSmallHeap
            // or in keepBigHeap , the same logic
            this.keepBigHeap.add(num);
            this.keepSmallHeap.add(this.keepBigHeap.poll());
        } else {
            this.keepSmallHeap.add(num);
            this.keepBigHeap.add(this.keepSmallHeap.poll());
        }
    }
    
    public double findMedian() {
        // System.out.println(this.keepSmallHeap.peek());
        // System.out.println(this.keepBigHeap.peek());
        return this.keepSmallHeap.size()==this.keepBigHeap.size()?(this.keepBigHeap.peek()+this.keepSmallHeap.peek())/2.0:this.keepBigHeap.peek();
    }
}

```