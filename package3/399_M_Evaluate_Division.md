This is a graph-like problem :

a->b b->c ** a->c multiple the weight

DFS Solution

```Java

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String,Map<String,Double>> graph = new HashMap<>();
        String u,v;
        for(int i=0;i<equations.size();i++) {
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);
            
            graph.putIfAbsent(u,new HashMap<String,Double>());
            graph.get(u).put(v,values[i]);
            graph.putIfAbsent(v,new HashMap<String,Double>());
            graph.get(v).put(u,1/values[i]);
        }
        
        double[] res = new double[queries.size()];
        String start,end;
        for(int i=0;i<queries.size();i++) {
            start = queries.get(i).get(0);
            end = queries.get(i).get(1);
            if(!graph.containsKey(start) || !graph.containsKey(end)) {
                res[i] = -1.0;
                continue;
            }
            
            res[i] = solve(start,end,graph,new HashSet<String>());
        }
        
        return res;
    }
    
    public double solve(String start,String end,Map<String,Map<String,Double>> graph,Set<String> set) {
        
        if(!graph.containsKey(start))
            return -1;
        if(graph.get(start).containsKey(end))
            return graph.get(start).get(end);
        
        set.add(start);
        for(Map.Entry<String,Double> entry:graph.get(start).entrySet()) {
            if(set.contains(entry.getKey()))
                continue;
            double nextWeight = solve(entry.getKey(),end,graph,set);
            if(nextWeight== -1.0)
                continue;
            return entry.getValue()*nextWeight;
        }
        
        return -1.0;
    }
    
   
}

```

This will be how we use Python to build the graph and dfs

```Python

class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        graph = collections.defaultdict(dict)
        for item,value in zip(equations,values):
            x,y = item
            graph[x][y]=value
            graph[y][x]=1.0/value
    
        res = []
        for q in queries:
            res.append(self.dfs(graph,q[0],q[1],set()))
        return res
    
    def dfs(self,graph,start:str,end:str,visited):
        if (not start in graph) or (not end in graph):
            return -1.0
        if start in graph and end in graph[start]:
            return graph[start][end]
        
        
        visited.add(start)
        for x,y in graph[start].items():
            if x in visited:
                continue
            next_weight = self.dfs(graph,x,end,visited)
            if next_weight!=-1.0:
                return y*next_weight
        
        return -1.0

```

---


Next is BFS Solution

https://leetcode.com/problems/evaluate-division/discuss/88275/Python-fast-BFS-solution-with-detailed-explantion

