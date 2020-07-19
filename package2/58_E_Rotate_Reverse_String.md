
Problem I

```Java

class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0)
            return s;
        StringBuilder res = new StringBuilder();
        for(String temp:s.split("\\s+")){
            res.insert(0,temp);
            res.insert(0," ");
        }
        return res.toString().trim();
    }
}

```

---

Problem II

```Java

class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] arr=s.toCharArray();
        n=n%arr.length;
        for(int i=0;i<n;i++){
            shift(arr);
        }
        return String.valueOf(arr);
    }

    public void shift(char[] arr) {
        char temp=arr[0];
        for(int i=1;i<arr.length;i++)
            arr[i-1]=arr[i];
        arr[arr.length-1]=temp;
    }
}

```