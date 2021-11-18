Problem Description:

```
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

```

Basic idea: 这道题有两种解法来做

第一种是 DFS，把每一次生成的元素都加进来
并且只从前往后加，这样一个元素就不会被重复加进来。

```Python
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        
        self.dfs(nums,res,[],0)
        
        return res
    
    def dfs(self,nums,res,path,index):
        if index > len(nums):
            return
        
        res.append(path[:])
        for i in range(index,len(nums)):
            path.append(nums[i])
            self.dfs(nums,res,path,i+1)
            path.pop()

```

第二种是 BFS，依次迭代：

```Python

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        
        for num in nums:
            temp = []
            for prefix in res:
                temp.append(prefix+[num])
            res += temp
        
        return res

```

对应 Java 解法如下：

Java 的 DFS 解法

```Java

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums==null) {
            return res;
        }
        
        traverse(nums,res,0,new ArrayList<Integer>());
        
        return res;
    }
    
    private void traverse(int[] nums,List<List<Integer>> res,int index,List<Integer> path) {
        
        if(index>nums.length) {
            return;
        }
        
        res.add(new ArrayList<>(path));
        for(int i=index;i<nums.length;i++) {
            path.add(nums[i]);
            traverse(nums,res,i+1,path);
            path.remove(path.size()-1);
        }
    }
}

```

而 Java 的 BFS 解法如下：

```Java

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums==null) {
            return res;
        }
        
        res.add(new ArrayList<>()); // for empty array
        
        for(int i=0;i<nums.length;i++) {
            int size = res.size();
            for(int j=0;j<size;j++) {
                List<Integer> curr = new ArrayList<>(res.get(j));
                curr.add(nums[i]);
                res.add(curr);
            }
        }
        
        return res;
    }
    
}

```