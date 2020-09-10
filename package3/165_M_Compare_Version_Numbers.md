
```Java

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int i=0,j=0;
        while(i<v1.length || j<v2.length) {
            int val1 = i<v1.length?Integer.parseInt(v1[i++]):0;
            int val2 = j<v2.length?Integer.parseInt(v2[j++]):0;
            
            if(val1>val2) {
                return 1;
            } else if(val1<val2) {
                return -1;
            }
        }
        
        return 0;
    }
}

```

This is Python implementation :

```Python
class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1 = [int(s) for s in version1.split('.')]
        v2 = [int(s) for s in version2.split('.')]
        
        for i in range(max(len(v1),len(v2))):
            value1 = v1[i] if i<len(v1) else 0
            value2 = v2[i] if i<len(v2) else 0
            
            if(value1>value2):
                return 1
            elif(value1<value2):
                return -1
        
        return 0

```