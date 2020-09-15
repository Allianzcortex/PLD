
A follow-up with 198:House Robber

The key of this problem is circle. So we break the problem into 2 parts:

1. choose nums[0],so it means we cannot choose nums[len-1], it will be `include_1st`

2. choose nums[1], and then we can choose nums[len-1].it is `exclude_1st`.

```Java

class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int include_1st = nums[0] + helper(nums,2,nums.length-2);
        int exclude_1st = helper(nums,1,nums.length-1);
        return Math.max(include_1st,exclude_1st);
    }
    
    public int helper(int[] nums,int left,int right) {
        
        int include = 0;
        int exclude = 0;
        
        for(int i=left;i<=right;i++) {
            int temp = exclude + nums[i];
            exclude = Math.max(include,exclude);
            include = temp;
        }
        
        return Math.max(include,exclude);
    }
}

```

TODO add Python Solution:

```Python


```