
Problem Description:

```Python

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

```

---

Java Solution , it should be pretty simple overall.

1. It already only had distinct values
2. skip the value that we already have

```Java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(res,path,nums);
        return res;
    }
    
    public void dfs(List<List<Integer>> res,List<Integer> path,int[] nums) {
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(path.contains(nums[i]))
                continue;
            path.add(nums[i]);
            dfs(res,path,nums);
            path.remove(new Integer(nums[i]));
        }
    }
}

```

And below is Python solution :

```Python

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        used = [False]*len(nums)
        
        res = []
        
        self.generate(nums,used,[],res)
        
        return res
    
    def generate(self,nums,used,temp,res):
        if len(temp)==len(nums):
            res.append(temp[:])
            return
        
        for index,val in enumerate(nums):
            if used[index]:
                continue
            
            used[index] = True
            self.generate(nums,used,temp+[val],res)
            used[index] = False

```