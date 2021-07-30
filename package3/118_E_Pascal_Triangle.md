
Pretty simple and straight-forward solution

```Java

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows<1)
            return res;
        
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for(int i=0;i<numRows;i++) {
            res.add(new ArrayList<>(cur));
            for(int j=i;j>0;j--) {
                // remember to from back to forth , calculate the res backwards
                // not from forth to back, not forwards
                cur.set(j,cur.get(j)+cur.get(j-1));
            }
            cur.add(1);
        }
        
        return res;
    }
}

```

---

For Python, I will use another brute-force solution, which also looks
very elegant(from Python's perspective)


```Python

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        
        for level in range(numRows):
            res.append([1]*(level+1))
            for i in range(1,level):
                # 2,1 1,0 1,1
                res[level][i] = res[level-1][i-1] + res[level-1][i]
        
        return res

```

while this is the simulation way , easier to understand :

```Python

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]]
        
        for _ in range(1,numRows):
            prev = res[-1]
            temp = [prev[0]]
            
            for index in range(0,len(prev)-1):
                temp.append(prev[index]+prev[index+1])
            
            temp.append(prev[-1])
            
            res.append(temp)
        
        return res
                
        

```