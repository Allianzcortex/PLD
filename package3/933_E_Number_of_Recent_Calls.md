
A design problem.

Try to solve it with multiple solutions.

1. `Linked List`

```Java
class RecentCounter {
    
    private Queue<Integer> queue;
    
    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.offer(t);
        
        while(queue.peek()<t-3000)
            queue.poll();
        
        return queue.size();   
    }
}
```

2. `TreeMap & TreeSize`

```Java

class RecentCounter {
    
    private TreeMap<Integer,Integer> tm;
    
    public RecentCounter() {
        tm = new TreeMap<>();
    }
    
    public int ping(int t) {
        tm.put(t,1);
        return tm.tailMap(t-3000).size();
    }
}

``

or 

```Java

class RecentCounter {
    
    private TreeSet<Integer> ts;
    
    public RecentCounter() {
        ts = new TreeSet<>();
    }
    
    public int ping(int t) {
        ts.add(t);
        return ts.tailSet(t-3000).size();
    }
}

```

3. Binary Search Solution :

```Java


```


```Python


```