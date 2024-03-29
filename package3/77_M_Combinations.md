
Problem description:

```
Given two integers n and k, return all possible combinations of k numbers out of 1 … n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

Basic idea:

这道题就是典型的不能再典型的一道 DFS 题，使用
pre-index 作为下一次循环的起始点

Python 解法如下：

```Python

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res=[]
        self.dfs(n,res,[],k,1)
        return res
    
    def dfs(self,n:int,res,path,k:int,index:int):
        if(len(path)==k):
            res.append(path)
            return
        for i in range(index,n+1):
            self.dfs(n,res,path+[i],k,i+1)

```

This is the Java Solution

Very Classic DFS problem

no need to use `boolean[] used` array,just use a pre-index,and 
everytime iterate from `pre-index`

```Java

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i]=i+1;
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        solve(nums,res,new ArrayList<Integer>(),k,used,0);
        return res;
    }
    
    public void solve(int[] nums,List<List<Integer>> res,List<Integer> path,int k,int index) {
        if(path.size()==k) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=index;i<nums.length;i++) { 
                path.add(nums[i]);
                solve(nums,res,path,k,used,i+1);
                path.remove(path.size()-1);
        }
    }
}

```