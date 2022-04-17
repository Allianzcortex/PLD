


Python Solution:

```Python

# 就先不列了，实在太经典了

```

---

Golang Solution 如下：

```Golang

func permutation(s string) []string {

    // 对 "abc" 来说，
    // length/cap 设置成 5，就是错误的
    // length/cap 设置成 6，就是对的
    // 因为要看 slice 后置 array 是否被改变
    res:=make([]string,5)
    used:=make([]bool,len(s))

    dfs(s,used,"",res)

    return res
}

func dfs(s string,used []bool,path string,res []string) {

    if len(path)==len(s) {
        res=append(res,path)
        return
    }

    for i:=0;i<len(s);i++ {
        if used[i] {
            continue
        }

        used[i] = true
        dfs(s,used,path+string(s[i]),res)
        used[i] = false
    }
}
```



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