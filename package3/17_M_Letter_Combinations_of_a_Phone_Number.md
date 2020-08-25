
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