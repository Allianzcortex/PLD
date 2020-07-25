
```Java

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(graph==null || graph.length==0)
            return res;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        solve(res,graph,0,path);
        
        return res;
    }
    
    public void solve(List<List<Integer>> res,int[][] graph,int node,List<Integer> path) {
        if(node==graph.length-1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int nextNode:graph[node]) {
            path.add(nextNode);
            solve(res,graph,nextNode,path);
            path.remove(path.size()-1);
        }
    }
}

```