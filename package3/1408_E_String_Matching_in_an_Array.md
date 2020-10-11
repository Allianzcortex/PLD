
Java Solution

Sort based on length and compare 1 by 1.

```Java

class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        List<String> res = new ArrayList<>();
        
        for(int i=0;i<words.length;i++) {
            String word = words[i];
            for(int j=i+1;j<words.length;j++) {
                if(words[j].indexOf(word)!=-1) {
                    res.add(word);
                    break;
                }
            }
        }
        
        return res;
    }
}


```

---

Python Solution

```Python

class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        s = ' '.join(words)
        return [x for x in words if s.count(x)>=2]

```