
This is my Java Solution 

```Java

class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int lateCount = 0;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if(arr[i]=='A') {
                absentCount += 1;
                if(absentCount>1)
                    return false;
            } else if(arr[i]=='L') {
                if(i+2<arr.length && arr[i]==arr[i+1] && arr[i+1]==arr[i+2])
                    return false;
            }
        }
        
        return true;
    }
}

```

And absolutely there are many other 1-line solutions :

Java Version :

```Java
public boolean checkRecord(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }

```

```Python
return s.count('A')<2 and s.count('LLL')==0

```