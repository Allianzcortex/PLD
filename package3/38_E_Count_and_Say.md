

```Java
class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String prev = countAndSay(n-1);
        char[] arr = prev.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<arr.length;) {
            int count = 1;
            while(i<arr.length-1 && arr[i]==arr[i+1]) {
                i++;
                count++;
            }
            // if(i==arr.length)
            //     i-=1;
            res.append(count).append(arr[i]);
            i+=1;
        }
        
        return res.toString();
    }
}

```

TODO : Add Python Solution