
```Java

class Solution {
    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        boolean[] visited = new boolean[s.length()];
        List<String> res = new ArrayList<>();
        dfs(arr,visited,res,"",0);
        String[] output = new String[res.size()];
        for(int i=0;i<res.size();i++)
            output[i]=res.get(i);
        return output;
    }

    public void dfs(char[] arr,boolean[] visited,List<String> res,String current,int index) {
        if(current.length()==arr.length) {
            res.add(new String(current));
            return;
        }

        for(int i=0;i<arr.length;i++) {
            if(visited[i])
                continue;
            if(i>0 &&arr[i-1]==arr[i] && !visited[i-1]) 
                continue;
            current=current+String.valueOf(arr[i]);
            visited[i]=true;
            dfs(arr,visited,res,current,index);
            visited[i]=false;
            current=current.substring(0,current.length()-1);
        }
    }
}

```