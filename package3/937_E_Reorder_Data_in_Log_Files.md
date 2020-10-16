

This is my solution here :

```Java

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> l1=new ArrayList<>();
        List<String> l2=new ArrayList<>();
        
        for(String s:logs) {
            char first=s.split(" ")[1].charAt(0);
            if(Character.isDigit(first))
                l2.add(s);
            else
                l1.add(s);
        }
    
        l1.sort((s1,s2)->{
            int spaceIdx1=s1.indexOf(" ");
            int spaceIdx2=s2.indexOf(" ");
            int comp=s1.substring(spaceIdx1+1).compareTo(s2.substring(spaceIdx2+1));
            if(comp==0)
                return s1.substring(0,spaceIdx1).compareTo(s2.substring(0,spaceIdx2));
            return comp;
        });
        String[] res=new String[logs.length];
        for(int i=0;i<l1.size();i++)
            res[i]=l1.get(i);
        for(int i=0;i<l2.size();i++)
            res[i+l1.size()]=l2.get(i);
        return res;
    }
}

```

TODO : add Python solutions and have a deeper understanding about it.