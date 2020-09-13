
The basic idea is to still use Stack :

1. Using two-passes

2. Using Stack to store the index instead of actual value.
#### in theory we can also use HashMap to do the same.

```Java

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null)
            return new int[]{};
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len*2;i++) {
            int index = i%len;
            while(!stack.isEmpty() && nums[stack.peek()]<nums[index])
                res[stack.pop()] = nums[index];
            stack.push(index);
        }
        return res;
    }
}

```