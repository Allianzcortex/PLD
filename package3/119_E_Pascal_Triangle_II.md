`

This is my initial solition,use two array to get the next row in order.
Not very effective one.


```Java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex<0)
            return res;
        
        List<Integer> pre = new ArrayList<>();
        res.add(1);
        for(int i=0;i<rowIndex;i++) {
            pre = new ArrayList<>(res);
            res.clear();
            res.add(1);
            for(int j=0;j+1<pre.size();j++) {
                res.add(pre.get(j)+pre.get(j+1));
            }
            res.add(1);
        }
        
        return res;
    }
}

```

We can use only one array to iterate the whole input :

```Java

class Solution {
    public List<Integer> getRow(int rowIndex) {
        /**
        1
        1 1
        
        **/
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i=1;i<=rowIndex;i++) {
            for(int j=i-1;j>0;j--) {
                res.set(j,res.get(j)+res.get(j-1));
            }
            res.add(1);
        }
        
        return res;
    }
}

```

---

This is the Python solution

```Python

class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        res = [1]
        for i in range(rowIndex):
            for j in range(i,0,-1):
                res[j]=res[j-1]+res[j]
            res.append(1)
        
        return res
        
        

```