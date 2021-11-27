
Problem description:

```

Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.

```

Basic idea:

一道很直观的 easy 题

Python 解法如下：

``` Python
class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        
        cnt = Counter(words[0])
        
        for i in range(1,len(words)):
            new_counter = Counter(words[i])
            for ch in cnt.keys():
                cnt[ch] = min(cnt[ch],new_counter[ch])

        return cnt.elements()
```

Golang 解法如下：

```Golang

func commonChars(words []string) []string {
    
    m:=make(map[rune]int)
    
    for _,val := range words[0] {
        m[val] += 1
    }
    
    for i:=1;i<len(words);i++ {
        // get new counter
        counter :=make([]int,26)
        
        for _,ch:=range words[i] {
            counter[ch-'a'] += 1
        }
        
        for k,v := range m {
            m[k] = min(v,counter[k-'a'])
        }
    }
    
    var res []string
    
    for k,v := range m {
        for j:=0;j<v;j++ {
            res = append(res,string(k))
        }
    }
    
    return res
    
}

func min(a,b int) int {
    if (a<b) {
        return a;
    }
    
    return b
}

```


cheat sheet : Golang rune -> string