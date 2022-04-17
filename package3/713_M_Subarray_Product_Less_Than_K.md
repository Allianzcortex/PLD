
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

一开始自己的思路是：prefix + product sum，但发现其中有一些 borken tests，所以下面的解法
并不能 AC:

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
                if(prefix[i+1]/prefix[j]<k)
                    res += 1;
            }
        }
        
        return res;
    }
}

```

所以 basic idea 还是用 sliding window 去做：
具体思路如下：
维持一个 window，这个 window 里数字的所有乘积<=k

比如 k = 6，nums 为 [1,2,3,4]

对第一个数 1，sum_ 为 1，符合要求，加入。
对第二个数 2，sum_ 为 1*2=2，window 仍然符合要求，此时根据前面的 1，会产生 2 个
新的 contiguous array，`[2]` 和 `[1,2]`
对第三个数 3，sum_ 为 2*3=6，window 仍然符合要求，此时根据前面的 `[1,2]`，会产生
3 个新的 contiguous array，`[3]`,`[2,3]` 和 `[1,2,3]`
对第四个数，sum_ 为 6*4=24，window 不符合要求，所以要移动 left，发现当 `left==2` 时候
sum_ 为 3*4=12 符合要求，此时根据前面的 `[3]`，会产生 2 个新的 array，`[4]` 和 `[3,4]`

即每次扩容，会生成 `j-i+1` 个新的 array

如果单个数字超过 k 的话，会有 right>left 的情况，即 `right-left=1`，这时候的 case 也是 0

对应 Python 解法如下：

```Python

class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
     
        cnt,prod = 0,1
        left,right = 0,0
        
        while right<len(nums):
            prod*=nums[right]
            
            while(left<=right and prod>=k):
                prod = prod // nums[left]
                left += 1
            
            cnt += (right-left+1)
            right += 1
        
        return cnt

```

Golang 解法如下：

```Golang

func numSubarrayProductLessThanK(nums []int, k int) int {
    
    cnt,product:=0,1
    
    for left,right := 0,0;right<len(nums);right++ {
        
        product*=nums[right]
        
        for left<=right && product>=k {
            product /= nums[left]
            left += 1
        }
        
        cnt += (right-left+1)
    }
    
    return cnt
    
}

```



