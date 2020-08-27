
1. Plain Solution

```Java

class Solution {
    public int countPrimes(int n) {
        int res = 0;
        for(int i=2;i<n;i++) {
            if(isPrime(i))
                res+=1;
        }
        
        return res;
    }
    
    public boolean isPrime(int n) {
        for(int i=2;i*i<=n;i++) {
            if(n%i==0)
                return false;
        }
        
        return true;
        
    }
}

```

2.  Sieve of Eratosthenes AKA(埃拉托斯特尼筛法)

```Java

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        
        for(int i=2;i*i<n;i++) {
            if(isPrime[i]) {
                for(int j=i*i;j<n;j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int res=0;
        for(int i=2;i<n;i++)
            if(isPrime[i])
                res+=1;
        return res;
    }
}


```