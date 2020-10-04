
My Solution : The basic idea is :

```
1. 

```

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