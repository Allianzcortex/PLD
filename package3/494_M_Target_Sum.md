
Problem description:

```

You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 

Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000

```

Basic idea:

这道题一看就能想出来的思路是 backtrack，因为每个 num 只有 
`+num` 和 `-num` 两种情况，加个 cache 可以完成优化：

解法如下：

```Python

class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        """
        list all combinations and see whether they sum equal to target
        """
        
        ops = [1]*len(nums)
        cache = {}
        
        return self.traverse(nums,target,0,0,cache)
    
    def traverse(self,nums,target,index,curr,cache):
        
        key = f"{index}#{curr}"
        if key in cache:
            return cache[key]
        
        if index>len(nums)-1:
            if target==curr:
                return 1
            return 0
        
        res = 0
        for sign in (1,-1):
            res += self.traverse(nums,target,index+1,curr+sign*nums[index],cache)
        
        cache[key] = res
        return res

```

接下来看如何用 DP 完成优化：

这里的 `dp` 想法虽然也是标注的 knapkack 问题，但感觉挺难的

