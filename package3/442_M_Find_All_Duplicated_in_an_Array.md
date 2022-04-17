
Problem description:

```

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice.

```

---

Basic idea:

这道题自己一开始用的是 set() 来做，Java 解法如下：

```Java

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        
        for(int num:nums) {
            if(!set.add(num))
                res.add(num);
        }
        
        return res;
    }
}

```

它符合题目里要求的 `O(n)` 时间复杂度，但不符合 `O(1)` 空间复杂度，也不符合一个
medium 题应该有的难度

如果要求 `O(1)` 空间复杂度的话就是或者用一个单变量，或者用 array 本身来存储
用 value 作为 index(value-1 来防止越界)，把 index 对应的值赋 1，如果 index 
已经是负数那就说明之前已经遇到过

代码如下：

```Python

class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        
        res = []
        
        for num in nums:
            index = abs(num)-1
            
            if nums[index]<0:
                res.append(index+1)
            nums[index]*=-1
        
        return res

```