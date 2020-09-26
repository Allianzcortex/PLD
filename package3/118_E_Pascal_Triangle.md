
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
        res = [[1]*(i+1) for i in range(numRows)]
        for i in range(numRows):
            for j in range(1,i):
                res[i][j] = res[i-1][j-1] + res[i-1][j]
        return res

```