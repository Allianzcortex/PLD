
There can be many solutions for this problem. I just provide
a simple one.

// TODO more can be added later

```Java

class Solution {
    public String toGoatLatin(String S) {
        if(S==null || S.length()==0)
            return S;
        
        StringBuilder res = new StringBuilder();
        String vowels = "aeiouAEIOU";
        String[] arr = S.split(" ");
        for(int i=0;i<arr.length;i++) {
            String temp = "";
            if(vowels.indexOf(arr[i].charAt(0)) != -1) {
                // apply 1st logic
                temp = arr[i]+"ma";
            } else {
                // apply 2nd logic
                temp = arr[i].substring(1) + arr[i].charAt(0) + "ma";
            }
            
            for(int j=0;j<i+1;j++)
                temp += "a";
            
            res.append(temp).append(" ");
        }
        
        // or we can use res.toStirng().trim();
        return res.toString().strip();
    }
}


```