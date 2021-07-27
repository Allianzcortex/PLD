
Problem Description:

```
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

```

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

And below is my Python solution :

```Python

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        res = []
        self.dfs(n,n,res,"")
        
        return res
    
    def dfs(self,left_cnt,right_cnt,res,temp):
        """
        left_cnt == right_cnt : only allow to add left_cnt
        left_cnt < right_cnt  : we can add both 
        left_cnt > right_cnt  : impossible
        
        """
        if left_cnt < 0:
            return

        if left_cnt==0 and right_cnt==0:
            res.append(temp)
            return
        
        if left_cnt == right_cnt:
            self.dfs(left_cnt-1,right_cnt,res,temp+"(")
        elif left_cnt < right_cnt:
            self.dfs(left_cnt-1,right_cnt,res,temp+"(")
            self.dfs(left_cnt,right_cnt-1,res,temp+")") 

```