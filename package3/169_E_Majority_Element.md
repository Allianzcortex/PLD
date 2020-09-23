

The Problem description is clear.

Java Solution:

1. Solution 1 : use HashMap to count and calculate

```Java
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums)
            map.put(num,map.getOrDefault(num,0)+1);
        // get threshold
        for(int num:map.keySet()) {
            if(map.get(num)>=nums.length/2+1)
                return num;
        }
        
        return -1;
    }
}

```

2. Solution 2 : Moore voting

```Java

class Solution {
    public int majorityElement(int[] nums) {
        int count=0,majority=0;
        for(int num:nums) {
            if(count==0) 
                majority = num;
            
            if(num==majority)
                count += 1;
            else 
                count -= 1;
        }
        
        return majority;
    }
}

```

3. Solution : Bit Manipulation

will check it when reviewing the bit algorithm

---


TODO : add python implementation