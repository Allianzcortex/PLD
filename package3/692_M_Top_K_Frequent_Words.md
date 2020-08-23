Java Solution:

with PriorityQueue

```Java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Map.Entry<String,Integer>> pq =new PriorityQueue<>((o1,o2)->(o2.getValue()==o1.getValue()?o1.getKey().compareTo(o2.getKey()):o2.getValue()-o1.getValue()));
        Map<String,Integer> map = new HashMap<>();
        for(String word:words)
            map.put(word,map.getOrDefault(word,0)+1);
        
        for(Map.Entry<String,Integer> entry:map.entrySet())
            pq.add(entry);
        String[] res = new String[k];
        int index = 0;
        while(index<k) {
            res[index++]=pq.poll().getKey();
        }
        
        return Arrays.asList(res);
    }
}
```

Absolutely it can be solved with bucket sort,will do it later.

---

Java Solution