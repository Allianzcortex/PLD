
This is my solution here :

long and verbose :

```Java

class Solution {
    public int maxNumberOfBalloons(String text) {
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:text.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        
        boolean flag = true;
        while(true) {
            for(char ch:"balloon".toCharArray()) {
                if(map.containsKey(ch)) {
                    if(map.get(ch)==1)
                        map.remove(ch);
                    else
                        map.put(ch,map.get(ch)-1);
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag)
                count+=1;
            else
                break;
        }
        
        return count;
    }
}


```

---

This is my second solution here :

```Java

class Solution {
    public int maxNumberOfBalloons(String text) {
        int count = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:text.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        
        for(char ch:"balloon".toCharArray()) {
            if(!map.containsKey(ch)) {
                count=0;
                break;
            }
            if(ch=='l' || ch=='o')
                count = Math.min(count,map.get(ch)/2);
            else
                count = Math.min(count,map.get(ch));
        }
        
        return count;
    }
}

```

It seems there are some solutions using `int[]` (although nearly similar with my second solution)