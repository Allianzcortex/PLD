
I will provide 2 solutions here :

Solution 1 : 2 arrays + bucket , straight-forward

```Java

class Solution {
    public String getHint(String secret, String guess) {
        int aCount=0,bCount=0;
        
        int[] sArr = new int[10];
        int[] bArr = new int[10];
        
        for(int i=0;i<secret.length();i++) {
            int a = secret.charAt(i)-'0';
            int b = guess.charAt(i)-'0';
            
            if(a==b) {
                aCount += 1;
            } else {
                sArr[a]+=1;
                bArr[b]+=1;
            }
        }
        
        
        for(int i=0;i<10;i++) {
            bCount += Math.min(sArr[i],bArr[i]);
        }
        
        return aCount+"A"+bCount+"B";
    }
}

```

Then solution2 is to reduce the space complexity, we can use just 1 array
to do it,and then to judge whether its positive or negative :

We can write the example below in the paper:

```
1 8 0 7
7 8 1 0
```
And then mock the array. It will be clear then.

```Java
class Solution {
    public String getHint(String secret, String guess) {
        int aCount=0,bCount=0;
        int[] arr = new int[10];
        
        for(int i=0;i<secret.length();i++) {
            int a = secret.charAt(i)-'0';
            int b = guess.charAt(i)-'0';
            
            if(a==b) {
                aCount += 1;
            } else {
                if(arr[a]<0) bCount+=1;
                if(arr[b]>0) bCount+=1;
                
                arr[a]+=1;
                arr[b]-=1;
            }
        }
        
        return aCount+"A"+bCount+"B";
        
    }
}


```

While this is a failure try :

```Java

class Solution {
    public String getHint(String secret, String guess) {
        int aCount=0,bCount=0;
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:secret.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        for(int i=0;i<guess.length();i++) {
            char ch = guess.charAt(i);
            if(ch ==secret.charAt(i)) {
                aCount += 1;
                map.put(ch,map.get(ch)-1);
                continue;
            } else {
                if(map.containsKey(ch) && map.get(ch)>0) {
                    bCount+=1;
                    map.put(ch,map.get(ch)-1);
                }
            }
        }
        
        StringBuilder res = new StringBuilder();
        res.append(aCount).append("A").append(bCount).append("B");
        
        return res.toString();
    }
}

```

It cannot pass the cases like 

```
"1122"
"1222"
```

---

Python Solution

