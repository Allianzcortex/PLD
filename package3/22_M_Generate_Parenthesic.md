
The basic idea is :

1. add left when leftCount > 0 

2. add right when left < right

The whole idea should be pretty straight-forward.

Java Solution:

```Java

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve(res,"",n,n);
        return res;
    }
    
    public void solve(List<String> res,String path,int leftCount,int rightCount) {
        if(leftCount==0 && rightCount==0) {
            res.add(path);
            return;
        }
        
        if(leftCount>0) {
            solve(res,path+"(",leftCount-1,rightCount);
        } 
        
        if(leftCount<rightCount) {
            solve(res,path+")",leftCount,rightCount-1);
        }
    }
}

```