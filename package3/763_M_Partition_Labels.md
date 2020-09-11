
The whole idea is straight-forward.

Find the right Index

```Java

    class Solution {
        public List<Integer> partitionLabels(String S) {
            List<Integer> res = new ArrayList<Integer>();
            if(S==null || S.length()==0)
                    return res;
            int[] rightIndexes = new int[26];
            for(int i=0;i<S.length();i++){
                rightIndexes[S.charAt(i)-'a']=i;
            }
            int last=0;
            int start=0;
            for(int i=0;i<S.length();i++){
                last=Math.max(last,rightIndexes[S.charAt(i)-'a']);
                if(last==i){
                    res.add(last-start+1);
                    start = last+1;
                }
            }
            return res;

        }
    }

```

This is Python solution

```Python

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        map = {}
        for i,val in enumerate(S):
            map[val] = i
        # or we can use just 1 line
        # map = {c:i for i, c in enumerate(S)}
        res = []
        last,start=0,0
        max_index = 0
        for i,val in enumerate(S):
            max_index = max(max_index,map[val])
            if i==max_index:
                res.append(i-start+1)
                start = i+1
        
        return res

```