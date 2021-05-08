```Java

class Solution {
    public int kthFactor(int n, int k) { 
        
        List<Integer> res=new ArrayList<>();
        int cnt=0;
        for(int i=1;i<=Math.sqrt(n);i++) {
            if(n%i==0) {
                if(++cnt==k) 
                    return i;
                if(i*i!=n)
                    res.add(n/i);
            }
        }
        // return the kth factor in this list or return -1 if n has less than k factors.
        if(cnt+res.size()<k)
            return -1;
        return res.get(res.size()-(k-cnt));
    }
}
```