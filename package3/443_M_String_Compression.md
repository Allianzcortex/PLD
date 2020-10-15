
My idea is to use two-pointers to calculate the length and add to the char.

There are some tricky parts :

```Java
class Solution {
    public int compress(char[] chars) {
        int left = 0 ,right =0;
        int idx = 0;
        // for the case like ["a","b","c"]
        // we must judge whether it is `left<length`,rather than `right < length`
        while(left<chars.length) {
        // also,it will be a little simpler if you write `chars[right]==chars[left]`
            while(right==0 || (right<chars.length && chars[right]==chars[right-1]))
                right += 1;
            chars[idx++]=chars[left];
            // if(right-left!=1) {
            //     int count = right-left;
            //     while(count!=0) {
            //     chars[idx++]=(char)((count%10)+'0');
            //     count/=10;
            //     }
            // }
            int count = right-left;
            if(count!=1) {
                for(char ch:String.valueOf(count).toCharArray())
                    chars[idx++] = ch;
            }
            left=right++;
        }
        
        return idx;
    }
}

```

Another two-pointer solution here :

```Java

class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int arrayIndex = 0;
        
        while(index<chars.length) {
            char current = chars[index];
            int count = 0;
            while(index<chars.length && chars[index]==current) {
                count++;
                index++;
            }
            
            chars[arrayIndex++] = current;
            if(count!=1) {
                for(char ch:String.valueOf(count).toCharArray())
                    chars[arrayIndex++] = ch;
            }
        }
        return arrayIndex;
    }
}

```