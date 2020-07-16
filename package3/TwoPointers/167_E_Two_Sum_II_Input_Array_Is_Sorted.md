It should be pretty straight forward

```Java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum ==target){
                return new int[]{left+1,right+1};
            } else if(sum<target){
                left += 1;
            } else {
                right -= 1;
            }
        }
        
        return new int[]{-1,-1};
    }
}
```