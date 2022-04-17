
Problem description :

```
Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
Example 3:

Input: nums = [1]
Output: "1"
Example 4:

Input: nums = [10]
Output: "10"

```

这道题最关键的就是自定义 sort 的方法，
自己之前想的逐位比较，如果有位数不足的就补全

Python Solution

TODO: 看 x 与 y 1 / -1 在排序时候的情况

```Python
from functools import cmp_to_key

class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        
        nums = [str(x) for x in nums]
        
        compare = lambda x,y:1 if x+y>y+x else -1 if x+y<y+x else 0
            
        
        nums.sort(key=cmp_to_key(compare),reverse=True)
        
        return "".join(nums).lstrip("0") or "0"
        
```

below is java solution:

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

