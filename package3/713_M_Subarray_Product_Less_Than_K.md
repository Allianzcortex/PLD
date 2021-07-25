
Initially I want to use prefix + product sum , but there are some broken test cases. Well , currently still no idea what happened...

```Java

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        long[] prefix = new long[len+1];
        prefix[0] = (long)1;
        for(int i=1;i<=len;i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        
        // 10 50 100 600
        
        int res = 0;
        for(int i=0;i<len;i++) {
            for(int j=0;j<=i;j++) {
                // calculate prefix[i] / prefix[j];
                if(prefix[j]==0)
                    System.out.println(i+" "+j+" "+prefix[i+1]+" "+prefix[j]);
                if(prefix[i+1]/prefix[j]<k)
                    res += 1;
            }
        }
        
        return res;
        
    }
}

```