
Problem description:

```

Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
 

Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106

```


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

所以 basic idea 还是用 sliding window 去做：

