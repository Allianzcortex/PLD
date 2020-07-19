
Many Edge Cases:e.g. more zero than gap & two same numbers

```Java

class Solution {
    public boolean isStraight(int[] nums) {
        int gapCount=0;
        Arrays.sort(nums);
        int index=0;
        while(index<nums.length & nums[index]==0){
            gapCount++;
            index++;
        }
        for(;index<nums.length-1;index++) {
            int gap=nums[index+1]-nums[index];
            if(gap==0)
                return false;
            if(gap!=1){
                gapCount-=(gap-1);
            }
        }
        return gapCount>=0;
    }
}
```