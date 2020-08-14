
The solution I use

```Java

class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(String p:path.split("/")) {
            if(p.equals("") || p.equals("."))
                continue;
            if(p.equals("..")){
                
                if(s.size()>0)
                    s.pop();
            }
            else
                s.push(p);    
        }
        
        
        for(String item:s) {
            res.append("/");
            res.append(item);
           
        }
        
        return res.length()==0?"/":res.toString();
        
    }
}

```