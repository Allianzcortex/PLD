Description : 

```
找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
 

限制：

2 <= n <= 100000

```

Java Solution

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int num:nums) {
            if(!set.add(num)) {
                res = num;
                break;
            }
        }
        return res;
    }
}

```

Python Solution:

```Python
class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:
        st = set()
        for num in nums:
            if not num in st:
                st.add(num)
            else:
                return num
        return -1
```

All solutions above are `time complexity(O(N)),space complexity(O(N))`

---

Another better way is like `sort and find indx`,because `所有数字都在 0～n-1 的范围内`, so 
we sort them and compare the value with index :

```Python

class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:
        size = len(nums)
        for i in range(size+1):
            while nums[i] != i:
                temp = nums[i]
                if temp == nums[temp]:
                    return temp
                else:
                    nums[i],nums[temp] = nums[temp],nums[i]
        return -1

```