
Java Solution

The key is : one number can be used multiple times.
So we sort the array first and select the index,then iterate from
index(try mulitple times)

```Java

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // use DFS
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        solve(res,0,0,new ArrayList<Integer>(),candidates,target);
        return res;
    }
    
    public void solve(List<List<Integer>> res,int index,int sum,List<Integer> cur,int[] candidates,int target) {
        if(sum==target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        if(sum>target)
            return;
        
        for(int i=index;i<candidates.length;i++) {
                cur.add(candidates[i]);
                solve(res,i,sum+candidates[i],cur,candidates,target);
                cur.remove(cur.size()-1);
        }
    }
}

```