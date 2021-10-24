
Problem description:

```

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10

```

Basic idea:

这道题是 46 Permutations 的变种

一种思路是用 set() 来存储结果，这样结果是对的但就和 46 没有什么区别了，

另外一种比较好的 DFS 思路是先排序，然后用一个 used[i] 来判别该数是否被用过，并且
每次遍历的时候不设置 `pre-index`，而是每次都从 0 开始：
这样的话比如 [1,1,1,2]，在第一个 1 遍历的时候剩余数组为 [1,1,2]，发现所有的继续循环条件都不满足；在第二个 1 遍历的时候第一个元素是 `1`，其余元素是 `[1,2]`，也很容易不满足条件；在遍历第三个 1 的时候，只有 `先遍历第三个 1，再遍历第二个 1，再遍历第一个 1`这种情况可以满足需求，所以就可以避免加入重复的 permutations。

Python 代码如下：

```Python

class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        used = [False]*len(nums)
        self.dfs(nums,res,[],used)
        
        return res
    
    def dfs(self,nums,res,path,used):
        if len(path)==len(nums):
            res.append(path[:])
            return
        
        for i in range(len(nums)):
            if used[i]:
                continue
            if i>0 and nums[i]==nums[i-1] and used[i-1]:
                return
            
            used[i]=True
            path.append(nums[i])
            self.dfs(nums,res,path,used)
            used[i]=False
            path.pop()
```

We sort the array first so we can skip the adjacent duplicates.

we use a boolean[] array to store whether a previous one is used.

```Java

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,used,res,new ArrayList<Integer>());
        return res;
    }
    
    public void dfs(int[] nums,boolean[] used,List<List<Integer>> res,List<Integer> path) {
        if(path.size()==nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=0;i<nums.length;i++) {
            if(used[i])
                continue;
            if(i>0 && nums[i]==nums[i-1] && used[i-1])
                return;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums,used,res,path);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}

```
