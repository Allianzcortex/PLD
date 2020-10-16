
The description of this problem is a little confusing...

This is my Java Solution :

count & binary search

```Java

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q=new int[queries.length],w=new int[words.length]; 
        
        for(int i=0;i<words.length;i++) {
            w[i] = calculate(words[i]);
            // System.out.println(w[i]);
        }
        
        Arrays.sort(w);
        
         for(int i=0;i<queries.length;i++)
            q[i] = binarySearch(calculate(queries[i]),0,w.length-1,w);
        
        return q;
    }
    
    public int binarySearch(int target,int left,int right,int[] arr) {
        if(target<arr[0])
            return arr.length;
        if(target>arr[right])
            return 0;
        
        while(left<=right) {
            int middle = left+(right-left)/2;
            // if(arr[middle]==target)
            //     return right-middle;
            // else if(arr[middle]<target)
            //     left = middle+1;
            if(arr[middle]<=target)
                left = middle + 1;
            else
                right = middle-1;
        }
        
        return arr.length-left;
    }
    
    public int calculate(String word) {
        
        Character smallestCh = null;
        int cnt = 0;
        for(char ch:word.toCharArray()) {
            if(smallestCh==null || ch<smallestCh) {
                cnt = 1;
                smallestCh = ch;
            } else if(ch==smallestCh)
                cnt+=1;
        }
        
        return cnt;
        
        // another way to caulcate frequency of smallest ch
        
        int[] arr = new int[26];
        for (char ch : word.toCharArray())
            arr[ch - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                return arr[i];
        }
        return 0;
    }
}

```

There is another solution without the use of Bianry Search :

https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/discuss/398951/Beats-100-time-and-beats-100-space.-Best-solution-out-there.-No-binary-search-needed.

TODO : check it later