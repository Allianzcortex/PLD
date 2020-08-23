Java Solution

```java

class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((o1,o2)->(o2.getValue()-o1.getValue()));
        
        for(char ch:s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        //  pq.addAll(map.entrySet());
        for(Map.Entry<Character,Integer> entry:map.entrySet()) {
            pq.offer(entry);
        }
        
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()) {
            // Map.Entry e = pq.poll();
            Map.Entry<Character,Integer> entry = pq.poll();
            for(int i=0;i<entry.getValue();i++)
                res.append(entry.getKey());
        }
        
        return res.toString();
    }
}

```

It can also be solved with BucketSort :

# To do later

---

Python Solution :

