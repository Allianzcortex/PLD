
Java Solution :

Use PriorityQueue

```Java

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((s1,s2)->(s2-s1));
        for(int stone:stones) {
            pq.add(stone);
        }
        
        while(pq.size()>1) {
            int s1 =pq.poll();
            int s2= pq.poll();
            if(s1!=s2)
                pq.add(s1-s2);
        }
        
        return pq.isEmpty()? 0: pq.peek();
    }
}

```

Another way is to use bucket sort, we can do it later.

---


Python Solution

