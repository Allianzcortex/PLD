```

Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1: str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other. Example 2: str = "aaabc", k = 3

Answer: ""

It is not possible to rearrange the string. Example 3: str = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.

```


---


The basic idea is to use `HashMap + PriorityQueue`

```Java

class Solution {
    public String rearrangeString(String str,int k) {
        int len = str.length();
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:str.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> pq = new 
            PriorityQueue<>((a,b)->(a.getValue()==b.getValue()?
                                   b.getKey().compareTo(a.getKey()):b.getValue()-a.getValue()));
        
        pq.addAll(map.entrySet());
        
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()) {
            List<Map.Entry<Character,Integer>> list = new ArrayList<>();
            int d = Math.min(k,len);
            
            for(int i=0;i<d;i++) {
                if(pq.isEmpty())
                    return "";
                Map.Entry<> pair = pq.poll();
                res.append(pair.getValue());
                if(pair.getKey()>1) {
                    pair.setValue(pair.getValue()-1);
                    res.add(pair);
                }
            }
            
            pq.addAll(res);
        }
        
        return res.toString();
    }
}


```