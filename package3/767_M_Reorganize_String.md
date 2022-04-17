
Problem description:

```
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.

```

这道题自己一开始的思路是完全正确的：就是找出 `most_common`，然后从最大的
取一个，从第二大的取一个，再从最大的取一个，依此类推，这就是很典型的 `heap` 使用场景：

Python 代码如下：

还有对时空复杂度的分析，O(nlogk)?

```Python

from heapq import heappush,heappop
class Solution:
    def reorganizeString(self, S):
        
        counter = Counter(S)
        queue = [(-1*count,val) for val,count in counter.most_common()]
        heapify(queue)
        res = []
        
        while len(queue)>=2:
            c1,val1 = heappop(queue)
            c2,val2 = heappop(queue)
            
            res.append(val1)
            res.append(val2)
            
            if abs(c1)>1:
                heappush(queue,(c1+1,val1))
            
            if abs(c2)>1:
                heappush(queue,(c2+1,val2))
        
        if queue:
            last_c,last_val = heappop(queue)
            if abs(last_c)!=1:
                return ""
            res.append(last_val)
        
        return "".join(res)
        
        # 下面这种解法也可以，但面试时候不一定能在很短时间内理顺逻辑关系
        # res, c = [], Counter(S)
        # pq = [(-value,key) for key,value in c.items()]
        # heapq.heapify(pq)
        # p_a, p_b = 0, ''
        # while pq:
        #     a, b = heapq.heappop(pq)
        #     res += [b]
        #     if p_a < 0:
        #         heapq.heappush(pq, (p_a, p_b))
        #     a += 1
        #     p_a, p_b = a, b
        # res = ''.join(res)
        # if len(res) != len(S): return ""
        # return res

```


还有很早以前自己的 Java 解法，完全看不懂现在...

```java

class Solution {
    public String reorganizeString(String S) {
        if(S==null || S.length()==0)
            return "";
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((o1,o2)->(o2.getValue()-o1.getValue()));
        
        for(char ch:S.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()) {
            pq.offer(entry);
        }
        
        StringBuilder res  = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character,Integer> cur = pq.poll();
            
            if(res.length()==0 || res.charAt(res.length()-1)!=cur.getKey()) {
                res.append(cur.getKey());
                cur.setValue(cur.getValue()-1);
                if(cur.getValue()!=0)
                    pq.offer(cur);
            } else {
                // try the 2nd highest one
                Map.Entry<Character,Integer> next = pq.poll();
                if(next==null)
                    return "";
                res.append(next.getKey());
                next.setValue(next.getValue()-1);
                if(next.getValue()!=0)
                    pq.offer(next);
                pq.offer(cur);
            }
        }
        
        return res.toString();
    }
}

```