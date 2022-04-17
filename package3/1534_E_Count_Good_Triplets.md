
This problem really makes no sense...... its not sorted so nearly 3-loop is the only choice

```Java
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for(int i=0;i<=arr.length-3;i++) {
            for(int j=i+1;j<=arr.length-2;j++) {
                if(Math.abs(arr[i]-arr[j])>a)
                    continue;
                for(int k=j+1;k<=arr.length-1;k++) {
                    if(Math.abs(arr[j]-arr[k])>b || Math.abs(arr[i]-arr[k])>c)
                        continue;
                    res+=1;
                }
            }
        }
        
        return res;
    }
}

```

---

```Python
class Solution:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        count = 0
        for i in range(0,len(arr)-2):
            for j in range(i+1,len(arr)-1):
                if abs(arr[i]-arr[j])>a:
                    continue
                for k in range(j+1,len(arr)):
                    if abs(arr[j]-arr[k])>b or abs(arr[i]-arr[k])>c:
                        continue
                    count += 1
        
        return count
        

```