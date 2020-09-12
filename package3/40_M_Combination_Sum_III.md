
My Java Solution

```Java

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates,path,result,0,0,target);
        return result;
    }
    
     public void solve(int[] candidates,List<Integer> path,List<List<Integer>> result,int index,int sum,int target){
        if(sum==target){
            result.add(new ArrayList<>(path));
            return;
        }
        if(sum>target)
            return;
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1])
                continue;
            path.add(candidates[i]);
            solve(candidates,path,result,i+1,sum+candidates[i],target);
            path.remove(path.size()-1);
        }
    }
}


```

And absolutely I need to add Python version :

