
This is my Java Solution , not effective :

```Java

class Solution {
    public int romanToInt(String s) {
        if(s==null || s.length()==0)
            return 0;
        int res = 0;
        Map<String,Integer> map = buildMap();
        
        for(int i=0;i<s.length();) {
            if(i+1<s.length() && map.containsKey(s.substring(i,i+2))) {
                res+=map.get(s.substring(i,i+2));
                i+=2;
            }else {
                res+=map.get(s.substring(i,i+1));
                i+=1;
            }
        }
            
        return res;
        
    }
    
    public Map<String,Integer> buildMap() {
        Map<String,Integer> map = new HashMap<>();
        
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        
        return map;
    }
}

```

A better solution should be :

Scan from left->right.

```Java

class Solution {
    public int romanToInt(String s) {
        if(s==null || s.length()==0)
            return 0;
       
        Map<Character,Integer> map = new HashMap<>();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
       
        int i=0,j=1;
        int res = 0;
        
        for(;j<s.length();i++,j++) {
            if(map.get(s.charAt(i))>=map.get(s.charAt(j)))
                res+=map.get(s.charAt(i));
            else
                res-=map.get(s.charAt(i));
        }
        res+=map.get(s.charAt(i));
        return res;
    }
}

```

---

TODO: Add Python Solution