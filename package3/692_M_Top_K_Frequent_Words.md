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

Python 解法如下：

```Python

class Word:
    
    def __init__(self,freq,word):
        self.freq = freq
        self.word = word
    
    def __lt__(self,other):
        if self.freq == other.freq:
            return self.word<other.word
        
        return self.freq > other.freq

class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        queue = [Word(freq,word) for (word,freq) in Counter(words).most_common()]
        
        heapify(queue)
        res = []
        
        for _ in range(k):
            res.append(heappop(queue).word)
        
        return res

```