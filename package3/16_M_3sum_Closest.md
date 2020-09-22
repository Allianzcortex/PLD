

The idea is like 3-sum problem.

Sort the array and use two-pointer to find the closest value.

Java Solution

```Java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res=nums[0]+nums[1]+nums[len-1];
        
        for(int i=0;i<len-2;i++) {
            int left=i+1,right=len-1;
            while(left<right) {
                int sum=nums[i]+nums[left]+nums[right];
                if(sum<target) {
                    left+=1;
                } else if(sum==target) {
                    return sum;
                } else {
                    right-=1;
                }
                
                if(Math.abs(sum-target)<Math.abs(res-target))
                    res=sum;
            }
        }
        
        return res;
        
    }
}

```

TODO : check discussions. There is one way to skip the duplicates
TODO : add Python solution