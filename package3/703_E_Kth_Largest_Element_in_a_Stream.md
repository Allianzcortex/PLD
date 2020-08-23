Idea : build the minheap.

when `pq.size()>k` , `pq.poll()` will return the smallest value.
So `Top k largest value` will always be in the pq and `the kth smallest one` will be 
on the top of pq.

Java Solution


```Java

class KthLargest {
    
    PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        this.k = k;
        for(int num:nums)
            add(num);
        
    }
    
    public int add(int val) {
        if(pq.size()<k)
            pq.add(val);
        else {
            pq.add(val);
            pq.poll();
        }
        
        return pq.peek();
        
    }
} 

```