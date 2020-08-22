The most important is to get all the logic right.



TLE Version :
```Java
class Solution {
    public boolean isMatch(String s, String p) {
        return compare(s,p,0,0,s.length(),p.length());
    }
    
    public boolean compare(String s,String p,int i,int j,int lenS,int lenP) {
        // case 1 can match
        if(i==lenS && j==lenP)
            return true;
        
        // case 2 if j has reached the end and i is not,then it will never match,return false instead
        if(j==lenP)
            return false;

        // case 3 
        if(i==lenS) 
            return p.charAt(j)=='*' && compare(s,p,i,j+1,lenS,lenP);
        
        if(p.charAt(j)=='*') {
            return compare(s,p,i+1,j,lenS,lenP) || compare(s,p,i,j+1,lenS,lenP);
        } else if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
            return compare(s,p,i+1,j+1,lenS,lenP);
        } else
            return false;
    }
}
```

Use Memo from Top to botton version :

```Java
class Solution {
    public boolean isMatch(String s, String p) {
        Map<List<Integer>,Boolean> map = new HashMap<>();
        return compare(s,p,0,0,s.length(),p.length(),map);
    }
    
    public boolean compare(String s,String p,int i,int j,int lenS,int lenP,Map<List<Integer>,Boolean> map) {
        List<Integer> key = Arrays.asList(i,j);
        if(map.containsKey(key))
            return map.get(key);
        boolean res = false;
        if(i==lenS && j==lenP)
            res = true;
        else if(j==lenP)
            res = false;
        else if(i==lenS) 
            res = p.charAt(j)=='*' && compare(s,p,i,j+1,lenS,lenP,map);
        else if(p.charAt(j)=='*') {
            res = compare(s,p,i+1,j,lenS,lenP,map) || compare(s,p,i,j+1,lenS,lenP,map);
        } else if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') {
            res = compare(s,p,i+1,j+1,lenS,lenP,map);
        } else {
            res = false;
        }
        
        map.put(key,res);
        return res;
    }
}

```

Then this will be the AC Solution :

```Java

class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        // (i,j) means (i-1)..(j-1)
        for(int i=0;i<m+1;i++) {
            for(int j=0;j<n+1;j++) {
                if(i==0 && j==0)
                    dp[i][j] = true;
                else if(j==0)
                    dp[i][0] = false;
                else if(i==0)
                    dp[i][j]=p.charAt(j-1)=='*' && dp[i][j-1];
                else if(p.charAt(j-1)=='*')
                    dp[i][j]=dp[i][j-1] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j-1] && (p.charAt(j-1)=='?' || s.charAt(i-1)==p.charAt(j-1));
            }
        }
        
        return dp[m][n];
    }
}

```

Apparently there are some tricks,so a verbose but more clear solution is :

https://leetcode.com/problems/wildcard-matching/discuss/17812/My-java-DP-solution-using-2D-table/17714

```Java


```