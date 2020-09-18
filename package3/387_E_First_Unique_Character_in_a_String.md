
The most intuitive and trivial is to use two-passes + O(N) space

```Java
class Solution {
    public int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        int[] frequency = new int[26];
        for(char ch:arr) {
            frequency[ch-'a']+=1;
        }
        
        for(int i=0;i<arr.length;i++) {
            if(frequency[arr[i]-'a']==1)
                return i;
        }
        
        return -1;
    }
}

```

Then a possible follow-up will be : how to handle
stream data ? we can use linkedhashmap

Basec on : [link](https://beginnersbook.com/2013/12/linkedhashmap-in-java/#:~:text=LinkedHashMap%20is%20a%20Hash%20table,interface%2C%20with%20predictable%20iteration%20order.&text=HashMap%20doesn't%20maintain%20any,LinkedHashMap%20maintains%20the%20insertion%20order.)

```
HashMap doesn’t maintain any order.
TreeMap sort the entries in ascending order of keys.
LinkedHashMap maintains the insertion order.
```

So this will be the 2nd solution:

```Java

class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        
        char[] ch =s.toCharArray();
        for(int i=0;i<ch.length;i++) {
            if(set.add(ch[i])) {
                map.put(ch[i],i);
            } else {
                map.remove(ch[i]);
            }
        }
        
        return map.size()==0?-1: map.entrySet().iterator().next().getValue();
    }
}

```

---

TODO : Add Python Solution