
Problem description:

```
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

 

Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
Example 3:

Input: graph = [[1],[]]
Output: [[0,1]]
Example 4:

Input: graph = [[1,2,3],[2],[3],[]]
Output: [[0,1,2,3],[0,2,3],[0,3]]
Example 5:

Input: graph = [[1,3],[2],[3],[]]
Output: [[0,1,2,3],[0,3]]
 

Constraints:

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
All the elements of graph[i] are unique.
The input graph is guaranteed to be a DAG.

```

Basic idea:

因为给的是 DAG，单项无环，所以不用考虑是否已经访问过，直接用 DFS 来遍历就行

Python 解法如下：

```Python

class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        res = []
        self.dfs(0,len(graph)-1,graph,[0],res)
        return res
    
    def dfs(self,start,end,graph,path,res):
        
        if path and path[-1]==end:
            res.append(path[:])
            return
        
        for next_node in graph[start]:
            path.append(next_node)
            self.dfs(next_node,end,graph,path,res)
            path.pop()

```

Golang 解法如下：

其中 Golang 的解法牵涉到了很多易错点，最重要的就是把 slice 作为 参数传递时，小心陷阱：

a. slice 改变 array 的某个值，underlying array 会改变，所以主函数里的 slice 也会改变
b. slice 用 append 的方法增加，会很容易造成 underlying array 扩容，等于一个新的底层函数
在被使用，所以主函数里的 slice 不会变。如果要想它变化的话用指针来作为参数

https://www.v2ex.com/t/496496
https://stackoverflow.com/questions/49428716/pass-slice-as-function-argument-and-modify-the-original-slice
https://stackoverflow.com/questions/39993688/are-slices-passed-by-value
https://stackoverflow.com/questions/33995634/are-golang-function-parameter-passed-as-copy-on-write


```Golang

func allPathsSourceTarget(graph [][]int) [][]int {
    
    res:=make([][]int,0)
    path:=[]int{0}
    
    dfs(graph,0,&path,&res)
    
    return res
}


func dfs(graph [][]int,start int,path *[]int,res *[][]int) {
    if(len(*path)>0 && (*path)[len(*path)-1]==len(graph)-1) {
        // copy
        temp := make([]int,len(*path))
        copy(temp,*path)
        *res = append(*res,temp)
        return
    }
    
    for _,v := range graph[start] {
        *path = append(*path,v)
        dfs(graph,v,path,res)
        *path = (*path)[0:len(*path)-1]
    }
}

```


Java 解法如下：

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