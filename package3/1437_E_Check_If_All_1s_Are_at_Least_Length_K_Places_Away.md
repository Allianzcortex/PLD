
The problem is pretty straight forward. I will explain
2 solutions in Python & Java.

Python Solution:

```Python

class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        prev_index = -1
        for i in range(len(nums)):
            if nums[i] == 1:
                if prev_index != -1 and i-prev_index-1<k :
                    return False
                prev_index = i
        
        return True
        

```

---

```Java

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int zeroCount = k; // or define zeroCount = k + 1,avoid returning False when meet 1 the 1st time
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                zeroCount += 1;
            } else {
                if(zeroCount < k )
                    return false;
                zeroCount = 0;
            }
        }
        
        return true;
    }
}

```