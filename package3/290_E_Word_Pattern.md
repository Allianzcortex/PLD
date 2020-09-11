
This is Java solution

Map.containsValue() is so tricky,time complexity will be pretty high

```Java

class Solution {
    public boolean wordPattern(String pattern, String str) {
//         pattern = "abba", str = "dog cat cat dog"
        
        String[] arr = str.split(" ");
        Map<Character,String> map = new HashMap<>();
        
        if(pattern.length()!=arr.length)
            return false;
        
        for(int i=0;i<arr.length;i++) {
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)) {
                if(map.containsValue(arr[i]))
                    return false;
                map.put(ch,arr[i]);
            } else {
                if(!map.get(ch).equals(arr[i]))
                    return false;
            }
        }
        
        return true;
        
    }
}

```

So the optimized solution is to use set() + Map() :

```Python

class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        s = set()
        map = {}
        str = str.split(" ")
        if len(pattern)!=len(str):
            return False
        
        for i in range(0,len(str)):
            if(not str[i] in map):
                if pattern[i] in s:
                    return False
                map[str[i]] = pattern[i]
                s.add(pattern[i])
            else:
                if(map[str[i]]!=pattern[i]):
                    return False
        
        return True


```