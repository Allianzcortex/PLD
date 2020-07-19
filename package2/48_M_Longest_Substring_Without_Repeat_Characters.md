
```Java

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        int res = 1;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0,j=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                // find one duplicate item,should update left index
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            res = Math.max(res,i-j+1);
        }

        return res;
    }
}

```