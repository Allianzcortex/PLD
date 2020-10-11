
Idea is to traverse from back to forth.
Also you can scan from forth to back and check whether `if(i<index && arr[i+2]==#`

```Java

class Solution {
    public String freqAlphabets(String s) {
        char[] arr = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i=s.length()-1;i>=0;) {
            if(arr[i]=='#') {
                res.append((char)('a'+(Integer.parseInt(s.substring(i-2,i))-1)));
                i-=3;
            } else {
                res.append((char)('a'+(arr[i]-'0'-1)));
                i-=1;
            }
        }
        
        return res.reverse().toString();
    }
}

```

