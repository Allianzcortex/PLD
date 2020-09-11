
Pretty basic DFS backtrack

This is java solution:

```Java
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res = new ArrayList<>();
        solve(res,new ArrayList<>(),0,1,k,n);
        return res;
    }
    
    public void solve(List<List<Integer>> res,List<Integer> path,int curVal,int index,int k,int n) {
        if(curVal==n && path.size()==k) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        if(curVal>=n || path.size()>k)
            return;
        
        for(int i=index;i<=9;i++) {
            path.add(i);
            solve(res,path,curVal+i,i+1,k,n);
            path.remove(path.size()-1);
        }
    }
}

```

---

TODO add python solution

