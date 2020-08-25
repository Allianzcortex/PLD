
Java Solution :

So for [4,6,7,7], we need to generate [4,6,7,7] which contains two 7,but we should
avoid [4,6,7] and [4,6,7], which can be generated twice if we donot use set to filter the duplicated items.

```Java

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(nums,res,new ArrayList<Integer>(),0);
        return res;
    }

    public void solve(int[] nums,List<List<Integer>> res,List<Integer> path,int index) {
        if(index>nums.length)
            return;
        if(path.size()>1)
            res.add(new ArrayList<>(path));
        Set<Integer> set = new HashSet<>();
        for(int i=index;i<nums.length;i++) {
            if(i!=0 && path.size()>0 && nums[i]<path.get(path.size()-1))
                continue;
            else {
                if(set.contains(nums[i]))
                    continue;
                path.add(nums[i]);
                set.add(nums[i]);
                solve(nums,res,path,i+1);
                path.remove(path.size()-1);
            }
        }
    }
}

```

---

TODO : Python Solution

```Python

```