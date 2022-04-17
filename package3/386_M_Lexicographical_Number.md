
Problem description:

```
class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        
        res = []
        queue = deque([])
        
        for i in range(1,10):
            
            self.dfs(i,n,res)
        return res
    
    def dfs(self,curr,n,res):
        if curr>n:
            return
        
        res.append(curr)
        
        for i in range(10):
            new_val = curr*10+i
            if new_val>n:
                return
            self.dfs(new_val,n,res)

```

Basic idea:

求序列最小的数字，用 `dfs` 就很容易解决，Python 解法如下：

```Python

class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        
        res = []
        queue = deque([])
        
        for i in range(1,10):
            
            self.dfs(i,n,res)
        return res
    
    def dfs(self,curr,n,res):
        if curr>n:
            return
        
        res.append(curr)
        
        for i in range(10):
            new_val = curr*10+i
            if new_val>n:
                return
            self.dfs(new_val,n,res)

```