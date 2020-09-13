
This is a pretty interesting problem.

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

---

TODO add Python Solution:
