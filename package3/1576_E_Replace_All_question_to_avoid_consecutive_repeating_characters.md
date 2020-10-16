

This is my failed solution which is a disaster

```Java
class Solution {
    public String modifyString(String s) {
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if(arr[i]=='?') {
                arr[i]=change(i,arr);
            }
        }
        
        return String.valueOf(arr);
    }
    
    public char change(int index,char[] arr) {
            // if index==0 && arr[index]=='a' then it will return a
            // special character rathen than a letter
            if(index==0)
                return arr[index+1]-1;
            else if(index==arr.length-1)
                return (char)(arr[arr.length-1]+1);
            else {
                for(int i=0;i<26;i++) {
                    if(('a'+i)!=arr[index-1] && ('a'+i)!=arr[index+1])
                        return (char)('a'+i);
                }
            }
            
            return 'a';
    }
}

```

This is an AC solution :

```Java

class Solution {
    public String modifyString(String s) {
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if(arr[i]=='?') {
                for(char ch='a';ch<='z';ch++) {
                    arr[i] = ch;
                    if(i>0 && arr[i-1]==ch) continue;
                    if(i+1<arr.length && arr[i+1]==ch) continue;
                    break;
                }
            }
        }
        
        return String.valueOf(arr);
    }
    
  
}

```