
This is my solution:

```Java

class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(i);
            dfs(builder,N,K,res);
        }
        if(N==1)
            res.add(0);
        
        int[] output = new int[res.size()];
        for(int i=0;i<res.size();i++)
            output[i] = res.get(i);
        return output;
    }
    
    public void dfs(StringBuilder path,int N,int K,List<Integer> res) {
        if(path.length()==N) {
            res.add(Integer.parseInt(path.toString()));
            return;
        }
        int cur = path.charAt(path.length()-1)-'0';
        if(K==0) {
            path.append(cur);
            dfs(path,N,K,res);
        } else {
            // try + and - two ways
            if(cur+K<=9) {
                path.append(cur+K);
                dfs(path,N,K,res);
                path.deleteCharAt(path.length()-1);
            }
            if(cur-K>=0) {
                path.append(cur-K);
                dfs(path,N,K,res);
                path.deleteCharAt(path.length()-1);
            }
        }
    }
}

```

The idea is clear but tricky, we donot need to use StringBuilder(),just use pure Integer will be enough.

Check this as the reference :

https://leetcode.com/problems/numbers-with-same-consecutive-differences/discuss/798716/Java-Idea-Explained-or-DFS-Easy-to-Understand