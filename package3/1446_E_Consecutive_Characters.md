
classic consecutive :

the 1st character and last character is annoying

My Solution here : count the number

```Java

class Solution {
    public int maxPower(String s) {
        if(s==null || s.length()==0)
            return 0;
        int maxLength = 1;
        int cnt = 1;
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i)==s.charAt(i-1))
                cnt++;
            else {
                maxLength = Math.max(maxLength,cnt);
                cnt=1;
            }
            
        }
        
        return Math.max(maxLength,cnt);
        
    }
}

```

---

Using 2-pointer solution here :

```Java
class Solution {
    public int maxPower(String s) {
            int res = 0, n = s.length();
            for(int i=0; i<n; i++){
                int j = i;
                while(i+1 < n && s.charAt(i) == s.charAt(i+1)) {i++;}  
                res = Math.max(i-j+1, res);
            }
            return res;
        }
}

```

