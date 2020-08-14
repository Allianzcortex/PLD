
This is Java solution

How to iterate throught HashMap , there are 3 ways:

for a Map like `Map<String,Integer> map` :

1. for keyset

```Java
for (String key:map.keySet()){    
}

```

2. for value set

```Java
for (Integer value:map.values()) {

}

```

3. for both key-value pairs

```Java
for (Map.Entry<String,Integer> entry:map.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue();
}

```

```Java

class Solution {
    public int longestPalindrome(String s) {
        boolean isOdd = false;
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        
        for(char ch:s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        for(Integer counter:map.values()) {
            if(counter%2==0)
                res+=counter;
            else {
                // remember not : res+=counter/2......
                res+=(counter-1);
                isOdd=true;
            }
        }
        
        return isOdd?res+1:res;
    }
}


```

---

This is Python implementation

```Python
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hash = set()
        counter = 0
        for ch in s:
            if(ch in hash):
                hash.remove(ch)
                counter+=1
            else:
                hash.add(ch)
        
        return counter*2 if len(hash)==0 else counter*2+1
        

```