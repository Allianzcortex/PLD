
TODO : will add more solutions

```Java

class Solution {
    public boolean backspaceCompare(String S, String T) {
        if(S==null || T==null)
            return false;
        return simplify(S).equals(simplify(T));
    }
    
    public String simplify(String s) {
        char[] arr=s.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<arr.length;) {
            if(arr[i]=='#'){
                // a##b 这种 trikcy 方法
                if(res.length()>0)
                    res.deleteCharAt(res.length()-1);
                i++;
                continue;
            }
            
            if(i+1<arr.length && arr[i+1]=='#'){
                i+=2;
                continue;
            }
            res.append(arr[i]);
            i+=1;
        }
        
        return res.toString();
    }
}

```