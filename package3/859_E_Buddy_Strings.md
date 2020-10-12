
This problem,the key is :

`ab` and `ab` should return false.
`aa` and `aa` should return true.

It seems that there is not a general way to handle those two cases,
must be set into a special condition.

This is my solution : 

```Java

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())
            return false;
        
        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }
        
        int[] count = new int[26];
        int diffCount = 0;
        for(int i=0;i<A.length();i++) {
            if(A.charAt(i)==B.charAt(i))
                continue;
            else {
                int index1=A.charAt(i)-'a';
                int index2=B.charAt(i)-'a';
                count[index1]++;
                count[index2]--;
                diffCount += 1;
            }
        }
        
        for(int i=0;i<26;i++)
            if(count[i]!=0)
                return false;
        return diffCount==2;
    }
}

```

Solution 2 : compare the index :

```Java

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())
            return false;
        
        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }
        
       List<Integer> diff = new ArrayList<>();
        for(int i=0;i<A.length();i++) {
            if(A.charAt(i)!=B.charAt(i))
                diff.add(i);
        }
        
        return diff.size()==2 && (A.charAt(diff.get(0))==B.charAt(diff.get(1))) && (A.charAt(diff.get(1)) ==B.charAt(diff.get(0)));
    }
}

```

---

Python Solution :

So simple & straight-forwad : clear

```Python

class Solution:
    def buddyStrings(self, A: str, B: str) -> bool:
        if(len(A)!=len(B)):
            return False
        if(A==B and len(set(A))<len(A)):
            return True
        
        dif=[(a,b) for a,b in zip(A,B) if a!=b]
        
        return len(dif)==2 and dif[0]==dif[1][::-1]
        

```