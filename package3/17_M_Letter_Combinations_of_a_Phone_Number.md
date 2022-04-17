
Java Solution : DFS

```Java

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0)
            return res;
        String[] board=new String[]{"","","abc","def","ghi","jkl","mno",
        "pqrs","tuv","wxyz"};
        solve(digits,board,0,res,"");
        return res;
        }

    public void solve(String digits,String[] board,int index,List<String> res,String path) {
        if(index==digits.length()) {
            res.add(path);
            return;
        };
        
        String temp = board[digits.charAt(index)-'0'];
        for(char ch:temp.toCharArray()) {
            solve(digits,board,index+1,res,path+ch);
        }
    }
    
}

```

This is BFS Solution :

```Java

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0)
            return res;
        String[] board=new String[]{"","","abc","def","ghi","jkl","mno",
        "pqrs","tuv","wxyz"};
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        int index = 0;

        while(index<digits.length()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String temp = queue.poll();
                for(char ch:board[digits.charAt(index)-'0'].toCharArray()) {
                    queue.add(temp+ch);
                }
            }
              index += 1;
        }

        res = new ArrayList<>(queue);
        return res;
    }    
}


```

Python Solution:

```Python

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        if digits is None or len(digits.strip(""))==0:
            return []
        
        match = ["","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"]
        
        res = [""]
        for ch in digits:
            # for nums in match[int(ch)]:
            # or if we don't do it, we will need to use a temporary variable
            # to store the new layer calculation result and assign new result to res
            # will need to do it using Golang again.
            res = [temp+nums for temp in res for nums in match[int(ch)]]
        
        return res
```
https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8063/Python-solution