
```Java

class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new LinkedHashMap<>();
        for(char ch:s.toCharArray()) {
            map.put(ch,!map.containsKey(ch));
        }
        for(Map.Entry<Character,Boolean> entry:map.entrySet()) {
           if(entry.getValue()) return entry.getKey();
        }

        return ' ';
    }
}

```