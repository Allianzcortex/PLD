
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

TODO add python solution