
Java Solution

```Java
class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return "";
        List<String> res = new ArrayList<>();
        
        for(int num:nums) {
            res.add(String.valueOf(num));
        }
        
        Collections.sort(res,(a,b)->((b+a).compareTo(a+b)));
        // An edge case
        if(res.get(0).charAt(0)=='0')
            return "0";
        StringBuilder output = new StringBuilder();
        for(String item:res)
            output.append(item);
        
        return output.toString();
    }
}

```

---

Python Solution

```Python

from functools import cmp_to_key

class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        def cmp(a,b):
            return int(b+a)-int(a+b)
        
        res=[str(num) for num in nums]
        res.sort(key=cmp_to_key(cmp))
        return ''.join(res).lstrip('0') or '0';
        

```