
Problem description:

```

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

```

Idea :

这道题很简单，就是用一个 map 来存储 sorted(word):word ，之后把
values 再顺次返回

Python Solution :

```Python

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        maps = defaultdict(list)
        
        for word in strs:
            maps[''.join(sorted(word))].append(word)
        
        return list(maps.values())

```

---

Golang Solution :

Go 语言实现的时候要注意一点，Go 没有对 string 的默认 built-in sort 方法，所以
要先换成 `[]byte` 再用 `sort.Slice()` 来排序，之后再转换为 `String()`

```Go

import "sort"

func groupAnagrams(strs []string) [][]string {
    
    m := make(map[string][]string)
    
    for _,word := range strs {
        b:=[]byte(word)
        sort.Slice(b, func(i,j int) bool {
            return b[i]<b[j]
        })
        key:=string(b)
        
        m[key] = append(m[key],word)
    }
    
    res := make([][]string,0,len(m))
    for _,val := range m {
        res = append(res,val)
    }
    
    return res
    
}

```

Java Solution :

```Java

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs==null || strs.length==0)
            return res;
        HashMap<String,List<String>> map= new HashMap<String,List<String>>();
        for(String str:strs) {
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String temp=String.valueOf(arr);
            if(map.containsKey(temp))
                map.get(temp).add(str);
            else {
                List<String> tempList = new ArrayList<String>();
                tempList.add(str);
                map.put(temp,tempList);
            }
        }
        
        for(List<String> item:map.values())
            res.add(item);
        return res;
    }
}

```