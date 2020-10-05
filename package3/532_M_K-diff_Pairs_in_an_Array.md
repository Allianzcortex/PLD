
My Solution : The basic idea is :

1. Binary Search for sorted : 

Need to avoid duplicates for both `i & j`.

```Java

class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return 0;
        
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;
        for(int i=0;i<len;i++) {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<len;j++) {
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                int key = Math.abs(nums[j]-nums[i]);
                if(key == k) {
                    res+=1;
                } else if(key > k) {
                    break;
                }
            }
        }
        
        return res;
    }
}

```

2. Use HashMap to avoid duplicates. Somehow like 2-sum.

```Java

class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1); // remove duplicates
        }
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(k==0) {
                if(entry.getValue()>=2)
                    res += 1;
            } else {
                if(map.containsKey(entry.getKey()+k)) // only +k will be enough,no need to consider -k.
                    res += 1;
            }
        }
        
        return res;
    }
}

```

TODO : Add Python Solution